private Server serverStart(int firstPort) throws IOException {
    String host = (this.publicServer) ? "0.0.0.0" : InetAddress.getLoopbackAddress().getHostAddress();
    int port, tries;
    if (firstPort < 0) {
        port = FreeCol.getServerPort();
        tries = 10;
    } else {
        port = firstPort;
        tries = 1;
    }
    logger.finest("serverStart(" + firstPort + ") => " + port + " x " + tries);
    Server ret = null;
    for (int i = tries; i > 0; i--) {
        try {
            ret = new Server(this, host, port);
            ret.start();
            break;
        } catch (IOException ie) {
            if (i <= 1)
                throw ie;
        }
        port++;
    }
    return ret;
}