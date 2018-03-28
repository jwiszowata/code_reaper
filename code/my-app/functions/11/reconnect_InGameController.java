public void reconnect() {
    final FreeColClient fcc = getFreeColClient();
    final Player player = getMyPlayer();
    if (getGUI().confirm("reconnect.text", "reconnect.no", "reconnect.yes")) {
        logger.finest("Reconnect quit.");
        fcc.getConnectController().requestLogout(LogoutReason.QUIT);
    } else {
        logger.finest("Reconnect accepted.");
        fcc.getConnectController().requestLogout(LogoutReason.RECONNECT);
    }
}