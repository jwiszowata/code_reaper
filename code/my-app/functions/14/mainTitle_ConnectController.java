public void mainTitle() {
    final FreeColClient fcc = getFreeColClient();
    if (fcc.isMapEditor())
        fcc.setMapEditor(false);
    if (fcc.isLoggedIn()) {
        if (getGUI().confirmStopGame()) {
            requestLogout(LogoutReason.MAIN_TITLE);
        }
        return;
    }
    fcc.stopServer();
    getGUI().removeInGameComponents();
    getGUI().mainTitle();
}