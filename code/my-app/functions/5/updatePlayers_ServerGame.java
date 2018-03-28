public void updatePlayers(List<ServerPlayer> players) {
    if (!players.isEmpty()) {
        sendToAll(new ChangeSet().addPlayers(players));
    }
}