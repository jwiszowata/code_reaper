public boolean clearGotoOrders(Unit unit) {
    if (!requireOurTurn() || unit == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askClearGotoOrders(unit);
    if (ret) {
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}