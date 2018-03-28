public int getTurnsForRepair() {
    return unitType.getHitPoints() - getHitPoints();
}