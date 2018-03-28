public ColonyBuilder player(Player player) {
    if (player == null || none(game.getPlayers(), matchKey(player))) {
        throw new IllegalArgumentException("Player not in game");
    }
    this.player = player;
    return this;
}