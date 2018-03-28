public static void stopClient(FreeColClient client) {
    client.getConnectController().requestLogout(LogoutReason.QUIT);
}