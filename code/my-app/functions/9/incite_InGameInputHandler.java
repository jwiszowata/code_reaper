private void incite(InciteMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final Unit unit = message.getUnit(player);
    final IndianSettlement is = message.getSettlement(unit);
    final Player enemy = message.getEnemy(game);
    final int gold = message.getGold();
    invokeLater(() -> igc().incite(unit, is, enemy, gold));
}