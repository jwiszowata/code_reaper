private boolean moveScoutIndianSettlement(Unit unit, Direction direction) {
    Tile unitTile = unit.getTile();
    Tile tile = unitTile.getNeighbourOrNull(direction);
    IndianSettlement is = tile.getIndianSettlement();
    Player player = unit.getOwner();
    askClearGotoOrders(unit);
    if (!askServer().scoutSettlement(unit, direction))
        return false;
    int count = player.getNationSummary(is.getOwner()).getNumberOfSettlements();
    String number = (count <= 0) ? Messages.message("many") : Integer.toString(count);
    ScoutIndianSettlementAction act = getGUI().getScoutIndianSettlementChoice(is, number);
    if (act == null)
        return true;
    switch(act) {
        case SCOUT_SETTLEMENT_ATTACK:
            if (!getGUI().confirmPreCombat(unit, tile))
                return true;
            askServer().attack(unit, direction);
            return false;
        case SCOUT_SETTLEMENT_SPEAK:
            moveMode = moveMode.minimize(MoveMode.EXECUTE_GOTO_ORDERS);
            askServer().scoutSpeakToChief(unit, is);
            return false;
        case SCOUT_SETTLEMENT_TRIBUTE:
            return moveTribute(unit, 1, direction);
        default:
            logger.warning("showScoutIndianSettlementDialog fail: " + act);
            break;
    }
    return true;
}