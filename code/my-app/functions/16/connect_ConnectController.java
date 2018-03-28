private StringTemplate connect(String user, String host, int port) {
    if (askServer().isConnected())
        return null;
    StringTemplate err = null;
    try {
        if (askServer().connect(FreeCol.CLIENT_THREAD + user, host, port) != null) {
            getFreeColClient().changeClientState(false);
            logger.info("Connected to " + host + ":" + port + " as " + user);
        } else {
            err = StringTemplate.template("server.couldNotConnect");
        }
    } catch (Exception ex) {
        err = FreeCol.errorFromException(ex, "server.couldNotConnect");
    }
    return err;
}