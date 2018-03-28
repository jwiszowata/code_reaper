public void shutdown() {
    Server server = getFreeColServer().getServer();
    if (server != null) {
        server.shutdown();
    } else {
        logger.warning("Tried to shut down a null server.");
    }
}