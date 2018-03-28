public ChangeSet addPlayers(List<ServerPlayer> serverPlayers) {
    changes.add(new PlayerChange(See.all(), serverPlayers));
    return this;
}