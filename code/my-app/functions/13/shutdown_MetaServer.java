public void shutdown() {
    running = false;
    try {
        serverSocket.close();
    } catch (IOException e) {
        logger.log(Level.WARNING, "Could not close the server socket!", e);
    }
    Connection c;
    while ((c = connections.remove(0)) != null) {
        c.disconnect();
    }
    logger.info("Server shutdown.");
}