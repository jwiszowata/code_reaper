public void sendToList(List<ServerPlayer> serverPlayers, ChangeSet cs) {
    for (ServerPlayer s : serverPlayers) sendTo(s, cs);
}