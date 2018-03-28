public void run() {
    while (running) {
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            logger.info("Client connection from: " + clientSocket.getInetAddress().toString());
            Connection connection = new Connection(clientSocket, getNetworkHandler(), FreeCol.METASERVER_THREAD);
            connections.put(clientSocket, connection);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Meta-run", e);
        }
    }
}