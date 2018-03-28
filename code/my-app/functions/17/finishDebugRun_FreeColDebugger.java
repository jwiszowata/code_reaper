public static boolean finishDebugRun(FreeColClient freeColClient, boolean force) {
    int turns = getDebugRunTurns();
    if (turns < 0 || turns > 0 && !force)
        return false;
    setDebugRunTurns(-1);
    if (getDebugRunSave() != null) {
        FreeColServer fcs = freeColClient.getFreeColServer();
        if (fcs != null) {
            try {
                fcs.saveGame(FreeColDirectories.getDebugRunSaveFile(), freeColClient.getClientOptions(), null);
            } catch (IOException e) {
            }
        }
        freeColClient.quit();
    }
    return true;
}