public ChangeSet addGlobalHistory(Game game, HistoryEvent history) {
    for (Player p : game.getLiveEuropeanPlayerList()) {
        addHistory((ServerPlayer) p, history);
    }
    return this;
}