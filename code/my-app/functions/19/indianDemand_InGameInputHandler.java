private void indianDemand(IndianDemandMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final Unit unit = message.getUnit(game);
    final Colony colony = message.getColony(game);
    final GoodsType goodsType = message.getType(game);
    final int amount = message.getAmount();
    if (unit == null) {
        logger.warning("IndianDemand with null unit.");
        return;
    }
    if (colony == null) {
        logger.warning("IndianDemand with null colony");
        return;
    } else if (!player.owns(colony)) {
        throw new IllegalArgumentException("Demand to anothers colony");
    }
    invokeLater(() -> igc().indianDemand(unit, colony, goodsType, amount));
}