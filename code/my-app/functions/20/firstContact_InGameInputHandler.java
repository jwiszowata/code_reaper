private void firstContact(FirstContactMessage message) {
    final Game game = getGame();
    final Player player = message.getPlayer(game);
    final Player other = message.getOtherPlayer(game);
    final Tile tile = message.getTile(game);
    final int n = message.getSettlementCount();
    if (player == null || player != getMyPlayer()) {
        logger.warning("firstContact with bad player: " + player);
        return;
    }
    if (other == null || other == player || !other.isIndian()) {
        logger.warning("firstContact with bad other player: " + other);
        return;
    }
    if (tile != null && tile.getOwner() != other) {
        logger.warning("firstContact with bad tile: " + tile);
        return;
    }
    invokeLater(() -> igc().firstContact(player, other, tile, n));
}