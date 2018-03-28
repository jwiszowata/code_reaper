public boolean unloadCargo(Goods goods, boolean dump) {
    if (!requireOurTurn() || goods == null || goods.getAmount() <= 0 || !(goods.getLocation() instanceof Unit))
        return false;
    final Unit carrier = (Unit) goods.getLocation();
    if (carrier.isInEurope())
        return sellGoods(goods);
    final Colony colony = carrier.getColony();
    ColonyWas colonyWas = (colony == null) ? null : new ColonyWas(colony);
    UnitWas unitWas = new UnitWas(carrier);
    boolean ret = askUnloadGoods(goods.getType(), goods.getAmount(), carrier);
    if (ret) {
        if (!dump)
            sound("sound.event.unloadCargo");
        if (colonyWas != null)
            colonyWas.fireChanges();
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}