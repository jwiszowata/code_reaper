public synchronized Connection connect(String name, String host, int port) throws IOException {
    int tries;
    if (port < 0) {
        port = FreeCol.getServerPort();
        tries = 10;
    } else {
        tries = 1;
    }
    for (int i = tries; i > 0; i--) {
        try {
            this.connection = new Connection(host, port, this.domMessageHandler, name);
            if (this.connection != null) {
                this.name = name;
                this.host = host;
                this.port = port;
                break;
            }
        } catch (IOException e) {
            if (i <= 1)
                throw e;
        }
    }
    return this.connection;
}