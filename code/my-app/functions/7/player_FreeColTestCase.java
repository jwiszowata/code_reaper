public IndianSettlementBuilder player(Player player) {
    if (player == null || none(game.getPlayers(), matchKey(player))) {
        throw new IllegalArgumentException("Indian player not in game");
    }
    this.indianPlayer = player;
    return this;
}