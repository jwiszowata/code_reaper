public boolean requestLogout(LogoutReason reason) {
    final FreeColClient fcc = getFreeColClient();
    final Player player = fcc.getMyPlayer();
    if (!fcc.isLoggedIn())
        return true;
    if (reason == LogoutReason.RECONNECT) {
        Unit active = getGUI().getActiveUnit();
        if (active != null && player.owns(active)) {
            FreeColServer fcs = fcc.getFreeColServer();
            if (fcs != null) {
                fcs.getGame().setInitialActiveUnitId(active.getId());
            }
        }
    }
    logger.info("Logout begin for client " + player.getName() + ": " + reason.toString());
    return askServer().logout(player, reason);
}