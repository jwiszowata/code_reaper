public ChangeSet addHistory(ServerPlayer serverPlayer, HistoryEvent history) {
    changes.add(new FeatureChange(See.only(serverPlayer), serverPlayer, history, true));
    serverPlayer.addHistory(history);
    return this;
}