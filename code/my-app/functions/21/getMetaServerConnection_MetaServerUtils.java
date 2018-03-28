private static Connection getMetaServerConnection(List<ServerInfo> lsi) {
    Consumer<List<ServerInfo>> consumer = (List<ServerInfo> l) -> {
    };
    if (lsi != null) {
        lsi.clear();
        lsi.add(sentinel);
        consumer = (l) -> {
            lsi.clear();
            if (lsi != null)
                lsi.addAll(l);
        };
    }
    String host = FreeCol.getMetaServerAddress();
    int port = FreeCol.getMetaServerPort();
    try {
        return new Connection(host, port, new MetaInputHandler(consumer), FreeCol.SERVER_THREAD);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Could not connect to meta-server: " + host + ":" + port, ioe);
    }
    return null;
}