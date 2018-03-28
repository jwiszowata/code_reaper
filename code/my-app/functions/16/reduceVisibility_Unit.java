public Unit reduceVisibility(Tile tile, Player player) {
    final Game game = getGame();
    Unit ret = this.copy(game, player);
    if (isOnCarrier()) {
        Unit carrier = getCarrier().copy(game, player);
        carrier.removeAll();
        carrier.add(ret);
        carrier.setLocationNoUpdate(tile);
        ret.setLocationNoUpdate(carrier);
    } else {
        ret.setLocationNoUpdate(tile);
        ret.setWorkType(null);
        ret.setState(Unit.UnitState.ACTIVE);
    }
    return ret;
}