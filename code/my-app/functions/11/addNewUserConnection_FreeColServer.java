public void addNewUserConnection(Socket socket) throws IOException {
    final String name = socket.getInetAddress() + ":" + socket.getPort();
    Connection c = new Connection(socket, this.userConnectionHandler, FreeCol.SERVER_THREAD + name);
    getServer().addConnection(c);
    Utils.delay(100, "New connection delay interrupted");
    c.send(new GameStateMessage(this.serverState));
    if (this.serverState == ServerState.IN_GAME) {
        c.send(new VacantPlayersMessage().setVacantPlayers(getGame()));
    }
    logger.info("Client connected from " + name);
}