public Controller getController() {
    return (getServerState() == ServerState.IN_GAME) ? this.inGameController : this.preGameController;
}