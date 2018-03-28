public void shutdown() {
    this.running = false;
    try {
        this.serverSocket.close();
        logger.fine("Closed server socket.");
    } catch (IOException e) {
        logger.log(Level.WARNING, "Could not close the server socket!", e);
    }
    synchronized (this.shutdownLock) {
        logger.fine("Wait for Server.run to complete.");
    }
    for (Connection c : transform(this.connections.values(), Connection::isAlive)) {
        c.sendDisconnect();
        c.close();
    }
    this.connections.clear();
    this.freeColServer.removeFromMetaServer();
    logger.fine("Server shutdown.");
}