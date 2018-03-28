private boolean isSafe() {
    final Unit unit = getUnit();
    return unit.isInEurope() || !unit.hasTile() || unit.getTile().hasSettlement();
}