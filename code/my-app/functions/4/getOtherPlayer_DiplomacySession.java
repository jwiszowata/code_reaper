public ServerPlayer getOtherPlayer(ServerPlayer serverPlayer) {
    ServerPlayer other = getOwner();
    return (other != serverPlayer) ? other : getOtherPlayer();
}