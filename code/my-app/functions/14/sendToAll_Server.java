public void sendToAll(DOMMessage message, Connection exceptConnection) {
    for (Connection conn : transform(connections.values(), c -> c != exceptConnection)) {
        if (conn.isAlive()) {
            try {
                conn.sendAndWait(message);
            } catch (IOException e) {
                logger.log(Level.WARNING, "Unable to send to: " + conn, e);
            }
        } else {
            logger.log(Level.INFO, "Reap dead connection: " + conn);
            removeConnection(conn);
        }
    }
}