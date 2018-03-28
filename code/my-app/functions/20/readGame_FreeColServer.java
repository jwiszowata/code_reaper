public static ServerGame readGame(File file, Specification spec, FreeColServer freeColServer) {
    ServerGame serverGame = null;
    try {
        serverGame = FreeColServer.readGame(new FreeColSavegameFile(file), spec, freeColServer);
        logger.info("Read file " + file.getPath());
    } catch (Exception e) {
        logger.log(Level.WARNING, "Read failed for " + file.getPath(), e);
    }
    File startGame = FreeColDirectories.getStartMapFile();
    if (startGame != null && startGame.getPath().equals(file.getPath())) {
        try {
            if (!file.delete()) {
                logger.warning("Failed to consume map: " + file.getPath());
            }
        } catch (SecurityException se) {
            logger.log(Level.WARNING, "Failed to delete map: " + file.getPath(), se);
        }
    }
    return serverGame;
}