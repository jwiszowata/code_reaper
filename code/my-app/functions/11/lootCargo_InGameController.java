public boolean lootCargo(Unit unit, List<Goods> goods, String defenderId) {
    if (unit == null || goods == null || goods.isEmpty() || defenderId == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().loot(unit, defenderId, goods);
    if (ret) {
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}