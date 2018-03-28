private void animateAttack(AnimateAttackMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final Unit attacker = message.getAttacker(game);
    final Unit defender = message.getDefender(game);
    final Tile attackerTile = message.getAttackerTile(game);
    final Tile defenderTile = message.getDefenderTile(game);
    final boolean result = message.getResult();
    if (attacker == null) {
        logger.warning("Attack animation for: " + player.getId() + " missing attacker.");
    }
    if (defender == null) {
        logger.warning("Attack animation for: " + player.getId() + " omitted defender.");
    }
    if (attackerTile == null) {
        logger.warning("Attack animation for: " + player.getId() + " omitted attacker tile.");
    }
    if (defenderTile == null) {
        logger.warning("Attack animation for: " + player.getId() + " omitted defender tile.");
    }
    invokeAndWait(() -> igc().animateAttack(attacker, defender, attackerTile, defenderTile, result));
}