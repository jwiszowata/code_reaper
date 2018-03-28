public void run() {
    synchronized (this.shutdownLock) {
        while (this.running) {
            try {
                Socket sock = serverSocket.accept();
                if (sock != null) {
                    this.freeColServer.addNewUserConnection(sock);
                }
            } catch (Exception e) {
                if (this.running) {
                    logger.log(Level.WARNING, "Connection failed: ", e);
                }
            }
        }
    }
}