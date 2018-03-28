public boolean assignTradeRoute(Unit unit, TradeRoute tradeRoute) {
    if (unit == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askAssignTradeRoute(unit, tradeRoute);
    if (ret) {
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}