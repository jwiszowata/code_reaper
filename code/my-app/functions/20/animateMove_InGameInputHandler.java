private void animateMove(AnimateMoveMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final Unit unit = message.getUnit(game);
    final Tile oldTile = message.getOldTile(game);
    final Tile newTile = message.getNewTile(game);
    if (unit == null) {
        logger.warning("Animation for: " + player.getId() + " missing Unit.");
        return;
    }
    if (oldTile == null) {
        logger.warning("Animation for: " + player.getId() + " missing old Tile.");
        return;
    }
    if (newTile == null) {
        logger.warning("Animation for: " + player.getId() + " missing new Tile.");
        return;
    }
    invokeAndWait(() -> igc().animateMove(unit, oldTile, newTile));
}