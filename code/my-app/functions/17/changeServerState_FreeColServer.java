private ServerState changeServerState(ServerState serverState) {
    ServerState ret = this.serverState;
    switch(this.serverState = serverState) {
        case PRE_GAME:
        case LOAD_GAME:
            getServer().setDOMMessageHandlerToAllConnections(this.preGameInputHandler);
            break;
        case IN_GAME:
            getServer().setDOMMessageHandlerToAllConnections(this.inGameInputHandler);
            break;
        case END_GAME:
        default:
            getServer().setDOMMessageHandlerToAllConnections(null);
            break;
    }
    return ret;
}