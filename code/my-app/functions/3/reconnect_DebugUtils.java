private static void reconnect(FreeColClient freeColClient) {
    freeColClient.getConnectController().requestLogout(LogoutReason.RECONNECT);
}