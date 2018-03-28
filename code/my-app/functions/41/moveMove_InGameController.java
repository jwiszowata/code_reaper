private boolean moveMove(Unit unit, Direction direction) {
    final ClientOptions options = getClientOptions();
    if (unit.canCarryUnits() && unit.hasSpaceLeft() && options.getBoolean(ClientOptions.AUTOLOAD_SENTRIES)) {
        List<Unit> waiting = (unit.getColony() != null) ? unit.getTile().getUnitList() : Collections.<Unit>emptyList();
        for (Unit u : waiting) {
            if (u.getState() != UnitState.SENTRY || !unit.couldCarry(u))
                continue;
            try {
                askEmbark(u, unit);
            } finally {
                if (u.getLocation() != unit) {
                    changeState(u, UnitState.SKIPPED);
                }
                continue;
            }
        }
        if (unit.getMovesLeft() <= 0)
            return false;
    }
    if (!askServer().move(unit, direction)) {
        changeState(unit, UnitState.SKIPPED);
        return false;
    }
    unit.getOwner().invalidateCanSeeTiles();
    final Tile tile = unit.getTile();
    if (unit.getMovesLeft() <= 0 && options.getBoolean(ClientOptions.UNIT_LAST_MOVE_DELAY)) {
        getGUI().paintImmediatelyCanvasInItsBounds();
        Utils.delay(UNIT_LAST_MOVE_DELAY, "Last unit move delay interrupted.");
    }
    boolean ret = !unit.isDisposed() && !checkCashInTreasureTrain(unit);
    if (ret) {
        if (tile.getColony() != null && unit.isCarrier()) {
            final Colony colony = tile.getColony();
            if (unit.getTradeRoute() == null && Map.isSameLocation(tile, unit.getDestination())) {
                colonyPanel(colony, unit);
            }
        }
        ret = unit.getMovesLeft() > 0;
    }
    return ret;
}