public boolean changeWorkType(Unit unit, GoodsType workType) {
    if (!requireOurTurn() || unit == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().changeWorkType(unit, workType) && unit.getWorkType() == workType;
    if (ret) {
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}