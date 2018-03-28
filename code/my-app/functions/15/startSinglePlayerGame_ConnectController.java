public boolean startSinglePlayerGame(Specification spec) {
    final FreeColClient fcc = getFreeColClient();
    fcc.setMapEditor(false);
    if (!fcc.unblockServer(FreeCol.getServerPort()))
        return false;
    if (fcc.isLoggedIn()) {
        logger.warning("startSinglePlayer while logged in!");
        requestLogout(LogoutReason.LOGIN);
    }
    List<FreeColModFile> mods = getClientOptions().getActiveMods();
    spec.loadMods(mods);
    Messages.loadActiveModMessageBundle(mods, FreeCol.getLocale());
    FreeColServer fcs = fcc.startServer(false, true, spec, -1);
    return (fcs == null) ? false : requestLogin(FreeCol.getName(), fcs.getHost(), fcs.getPort());
}