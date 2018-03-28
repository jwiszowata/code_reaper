public void loadGame() {
    File file = getGUI().showLoadSaveFileDialog();
    if (file == null)
        return;
    if (getFreeColClient().isInGame() && !getGUI().confirmStopGame())
        return;
    turnReportMessages.clear();
    getGUI().setActiveUnit(null);
    getGUI().removeInGameComponents();
    FreeColDirectories.setSavegameFile(file.getPath());
    getConnectController().startSavedGame(file);
}