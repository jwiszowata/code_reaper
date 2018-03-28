public void sendToAll(ChangeSet cs, ServerPlayer... serverPlayers) {
    sendToList(getConnectedPlayers(), cs);
}