public void newGame() {
    final FreeColClient fcc = getFreeColClient();
    if (fcc.isMapEditor()) {
        fcc.getMapEditorController().newMap();
        return;
    }
    if (fcc.isLoggedIn()) {
        if (getGUI().confirmStopGame()) {
            requestLogout(LogoutReason.NEW_GAME);
        }
        return;
    }
    fcc.stopServer();
    getGUI().removeInGameComponents();
    getGUI().showNewPanel(null);
}