public synchronized boolean removeFromMetaServer() {
    if (!this.publicServer)
        return false;
    boolean ret = MetaServerUtils.removeServer(getServerInfo());
    if (!ret)
        this.publicServer = false;
    return ret;
}