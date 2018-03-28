private void lootCargo(LootCargoMessage message) {
    final Game game = getGame();
    final Unit unit = message.getUnit(game);
    final String defenderId = message.getDefenderId();
    final List<Goods> goods = message.getGoods();
    if (unit == null || goods == null)
        return;
    invokeLater(() -> igc().loot(unit, goods, defenderId));
}