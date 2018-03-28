private static void startClient(String userMsg) {
    Specification spec = null;
    File savegame = FreeColDirectories.getSavegameFile();
    if (debugStart) {
        spec = FreeCol.getTCSpecification();
    } else if (fastStart) {
        if (savegame == null) {
            savegame = FreeColDirectories.getLastSaveGameFile();
            if (savegame == null) {
                spec = FreeCol.getTCSpecification();
            }
        }
    }
    final FreeColClient freeColClient = new FreeColClient(splashStream, fontName, guiScale, headless);
    freeColClient.startClient(windowSize, userMsg, sound, introVideo, savegame, spec);
}