public synchronized boolean updateMetaServer() {
    if (!this.publicServer)
        return false;
    boolean ret = MetaServerUtils.updateServer(getServerInfo());
    if (!ret)
        this.publicServer = false;
    return ret;
}