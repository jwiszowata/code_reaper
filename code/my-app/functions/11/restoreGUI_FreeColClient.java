public void restoreGUI(Player player) {
    final Game game = getGame();
    Unit u = game.getInitialActiveUnit();
    if (u != null) {
        player.setNextActiveUnit(u);
    } else {
        player.resetIterators();
    }
    u = player.getNextActiveUnit();
    getGUI().reconnect((u != null && player.owns(u)) ? u : null, player.getFallbackTile());
}