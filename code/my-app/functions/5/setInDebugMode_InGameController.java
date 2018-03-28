public boolean setInDebugMode() {
    FreeColDebugger.enableDebugMode(FreeColDebugger.DebugMode.MENUS);
    getFreeColClient().getConnectController().requestLogout(LogoutReason.RECONNECT);
    return true;
}