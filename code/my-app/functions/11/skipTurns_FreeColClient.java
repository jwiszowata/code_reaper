public void skipTurns(int turns) {
    if (freeColServer == null)
        return;
    if (turns <= 0) {
        freeColServer.getInGameController().setSkippedTurns(0);
        return;
    }
    gui.closeMenus();
    freeColServer.getInGameController().setSkippedTurns(turns);
    askServer().startSkipping();
}