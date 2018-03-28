private static void startServer() {
    logger.info("Starting stand-alone server.");
    final FreeColServer freeColServer;
    File saveGame = FreeColDirectories.getSavegameFile();
    if (saveGame != null) {
        try {
            final FreeColSavegameFile fis = new FreeColSavegameFile(saveGame);
            freeColServer = new FreeColServer(fis, (Specification) null, serverPort, serverName);
            if (checkIntegrity) {
                String k;
                int ret;
                switch(freeColServer.getIntegrity()) {
                    case 1:
                        k = "cli.check-savegame.success";
                        ret = 0;
                        break;
                    case 0:
                        k = "cli.check-savegame.fixed";
                        ret = 2;
                        break;
                    case -1:
                    default:
                        k = "cli.check-savegame.failure";
                        ret = 3;
                        break;
                }
                gripe(StringTemplate.template(k).add("%log%", FreeColDirectories.getLogFilePath()));
                System.exit(ret);
            }
        } catch (Exception e) {
            if (checkIntegrity)
                gripe("cli.check-savegame.failure");
            fatal(Messages.message(badFile("error.couldNotLoad", saveGame)) + ": " + e.getMessage());
            return;
        }
    } else {
        Specification spec = FreeCol.getTCSpecification();
        try {
            freeColServer = new FreeColServer(publicServer, false, spec, serverPort, serverName);
        } catch (Exception e) {
            fatal(Messages.message("server.initialize") + ": " + e.getMessage());
            return;
        }
        if (publicServer && freeColServer != null && !freeColServer.getPublicServer()) {
            gripe(Messages.message("server.noRouteToServer"));
        }
    }
    String quit = FreeCol.SERVER_THREAD + "Quit Game";
    Runtime.getRuntime().addShutdownHook(new Thread(quit) {

        @Override
        public void run() {
            freeColServer.getController().shutdown();
        }
    });
}