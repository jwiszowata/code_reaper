public void addPlayerConnection(Connection connection) {
    switch(this.serverState) {
        case PRE_GAME:
        case LOAD_GAME:
            connection.setDOMMessageHandler(this.preGameInputHandler);
            break;
        case IN_GAME:
            connection.setDOMMessageHandler(this.inGameInputHandler);
            break;
        case END_GAME:
        default:
            return;
    }
    getServer().addConnection(connection);
    updateMetaServer();
}