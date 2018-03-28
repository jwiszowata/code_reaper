public ChangeSet addGlobalMessage(Game game, ServerPlayer omit, ModelMessage message) {
    for (Player p : game.getLiveEuropeanPlayerList()) {
        if (p == (Player) omit)
            continue;
        addMessage((ServerPlayer) p, message);
    }
    return this;
}