private boolean moveTribute(Unit unit, int amount, Direction direction) {
    final Game game = getGame();
    Player player = unit.getOwner();
    Tile tile = unit.getTile();
    Tile target = tile.getNeighbourOrNull(direction);
    Settlement settlement = target.getSettlement();
    Player other = settlement.getOwner();
    if (settlement.getOwner().isIndian()) {
        askServer().demandTribute(unit, direction);
        return false;
    }
    DiplomaticTrade agreement = DiplomaticTrade.makePeaceTreaty(TradeContext.TRIBUTE, player, other);
    agreement.add(new GoldTradeItem(game, other, player, amount));
    return moveDiplomacy(unit, direction, agreement);
}