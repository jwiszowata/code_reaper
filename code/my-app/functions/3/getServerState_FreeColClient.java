public ServerState getServerState() {
    return (this.freeColServer == null) ? this.cachedServerState : this.freeColServer.getServerState();
}