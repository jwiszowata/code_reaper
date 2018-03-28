public VacantPlayersMessage setVacantPlayers(Game game) {
    if (game == null)
        return this;
    final Predicate<Player> vacantPred = p -> !p.isREF() && (p.isAI() || !((ServerPlayer) p).isConnected());
    setArrayAttributes(transform(game.getLiveEuropeanPlayers(), vacantPred, Player::getNationId));
    return this;
}