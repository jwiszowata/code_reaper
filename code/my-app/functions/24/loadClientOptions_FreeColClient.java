private ClientOptions loadClientOptions(File savedGameFile) {
    ClientOptions clop = new ClientOptions();
    logger.info("Load default client options.");
    clop.load(FreeColDirectories.getBaseClientOptionsFile());
    if (actionManager != null) {
        logger.info("Load client options from the action manager.");
        clop.add(actionManager);
    }
    if (savedGameFile != null) {
        try {
            FreeColSavegameFile fcsf = new FreeColSavegameFile(savedGameFile);
            logger.info("Merge client options from saved game: " + savedGameFile.getPath());
            clop.merge(fcsf);
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Could not open saved game " + savedGameFile.getPath(), ioe);
        }
    }
    final File userOptions = FreeColDirectories.getClientOptionsFile();
    if (userOptions != null && userOptions.exists()) {
        logger.info("Merge client options from user options file: " + userOptions.getPath());
        clop.merge(userOptions);
    }
    return clop;
}