public int evaluateFor(Player player) {
    final Colony colony = getColony(player.getGame());
    return (colony == null || !getSource().owns(colony)) ? Integer.MIN_VALUE : colony.evaluateFor(player);
}