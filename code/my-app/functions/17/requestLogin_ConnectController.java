public boolean requestLogin(String user, String host, int port) {
    final FreeColClient fcc = getFreeColClient();
    if (fcc.isLoggedIn())
        return true;
    fcc.setMapEditor(false);
    askServer().disconnect();
    StringTemplate err = connect(user, host, port);
    if (err == null) {
        logger.info("Login request for client " + FreeCol.getName());
        if (askServer().login(user, FreeCol.getVersion(), fcc.getSinglePlayer(), fcc.currentPlayerIsMyPlayer())) {
            return true;
        }
        err = StringTemplate.template("server.couldNotLogin");
    }
    getGUI().showErrorMessage(err);
    return false;
}