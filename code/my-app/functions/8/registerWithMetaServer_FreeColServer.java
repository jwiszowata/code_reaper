public synchronized boolean registerWithMetaServer() {
    if (!this.publicServer)
        return false;
    boolean ret = MetaServerUtils.registerServer(getServerInfo());
    if (!ret)
        this.publicServer = false;
    return ret;
}