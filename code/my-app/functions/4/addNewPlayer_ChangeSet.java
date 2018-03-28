public ChangeSet addNewPlayer(ServerPlayer serverPlayer) {
    changes.add(new PlayerChange(See.all().except(serverPlayer), Collections.singletonList(serverPlayer)));
    return this;
}