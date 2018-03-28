private boolean saveGame(final File file) {
    final FreeColServer server = getFreeColServer();
    boolean result = false;
    if (server != null) {
        getGUI().showStatusPanel(Messages.message("status.savingGame"));
        try {
            server.saveGame(file, getClientOptions(), getGUI().getActiveUnit());
            result = true;
        } catch (IOException ioe) {
            getGUI().showErrorMessage(FreeCol.badFile("error.couldNotSave", file));
            logger.log(Level.WARNING, "Save fail", ioe);
        } finally {
            getGUI().closeStatusPanel();
        }
    }
    return result;
}