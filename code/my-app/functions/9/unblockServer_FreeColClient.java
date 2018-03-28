public boolean unblockServer(int port) {
    final FreeColServer freeColServer = getFreeColServer();
    if (freeColServer != null && freeColServer.getServer().getPort() == port) {
        if (!getGUI().confirm("stopServer.text", "stopServer.yes", "stopServer.no"))
            return false;
        stopServer();
    }
    return true;
}