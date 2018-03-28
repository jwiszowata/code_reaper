public synchronized void addServer(ServerInfo newSi) {
    ServerInfo si = getServer(newSi.getAddress(), newSi.getPort());
    if (si == null) {
        final String identity = newSi.getName() + " (" + newSi.getAddress() + ":" + newSi.getPort() + ")";
        Connection mc = null;
        try {
            mc = new Connection(newSi.getAddress(), newSi.getPort(), null, FreeCol.METASERVER_THREAD);
            if (mc == null) {
                logger.info("Server not found: " + identity);
            } else {
                items.add(newSi);
                logger.info("Server added:" + identity);
            }
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Server fail: " + identity, ioe);
        }
    } else {
        si.update(newSi);
    }
}