public boolean leaveShip(Unit unit) {
    Unit carrier;
    if (!requireOurTurn() || unit == null || (carrier = unit.getCarrier()) == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().disembark(unit) && unit.getLocation() != carrier;
    if (ret) {
        checkCashInTreasureTrain(unit);
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}