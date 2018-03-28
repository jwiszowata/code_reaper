public boolean startMultiplayerGame(Specification specification, boolean publicServer, int port) {
    final FreeColClient fcc = getFreeColClient();
    fcc.setMapEditor(false);
    if (!fcc.unblockServer(port))
        return false;
    if (fcc.isLoggedIn()) {
        logger.warning("startMultiPlayer while logged in!");
        requestLogout(LogoutReason.LOGIN);
    }
    FreeColServer fcs = fcc.startServer(publicServer, false, specification, port);
    if (fcs == null)
        return false;
    fcc.setFreeColServer(fcs);
    fcc.setSinglePlayer(false);
    return requestLogin(FreeCol.getName(), fcs.getHost(), fcs.getPort());
}