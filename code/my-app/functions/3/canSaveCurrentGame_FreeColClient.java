public boolean canSaveCurrentGame() {
    return freeColServer != null && (isAdmin() || freeColServer.getServerState() != ServerState.IN_GAME);
}