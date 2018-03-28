public void changeAI(ServerPlayer serverPlayer, boolean ai) {
    serverPlayer.setAI(ai);
    sendToAll(ChangeSet.aiChange(serverPlayer, ai));
}