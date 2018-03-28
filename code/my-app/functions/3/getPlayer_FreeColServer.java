public ServerPlayer getPlayer(Connection connection) {
    return (ServerPlayer) find(getGame().getPlayers(), p -> ((ServerPlayer) p).getConnection() == connection);
}