public void sendToAll(DOMMessage msg, ServerPlayer serverPlayer) {
    sendToAll(msg, (serverPlayer == null) ? null : serverPlayer.getConnection());
}