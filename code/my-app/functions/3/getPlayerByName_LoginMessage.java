public ServerPlayer getPlayerByName(Game game) {
    return (ServerPlayer) game.getPlayerByName(this.userName);
}