public void removePlayerConnection(ServerPlayer serverPlayer) {
    getServer().removeConnection(serverPlayer.getConnection());
    serverPlayer.disconnect();
}