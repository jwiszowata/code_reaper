public boolean checkCashInTreasureTrain(Unit unit) {
    if (!requireOurTurn() || unit == null || !unit.canCarryTreasure() || !unit.canCashInTreasureTrain())
        return false;
    final Tile tile = unit.getTile();
    final Europe europe = unit.getOwner().getEurope();
    if (europe == null || unit.isInEurope()) {
        ;
    } else {
        int fee = unit.getTransportFee();
        StringTemplate template;
        if (fee == 0) {
            template = StringTemplate.template("cashInTreasureTrain.free");
        } else {
            int percent = getSpecification().getInteger(GameOptions.TREASURE_TRANSPORT_FEE);
            template = StringTemplate.template("cashInTreasureTrain.pay").addAmount("%fee%", percent);
        }
        if (!getGUI().confirm(unit.getTile(), template, unit, "accept", "reject"))
            return false;
    }
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().cashInTreasureTrain(unit) && unit.isDisposed();
    if (ret) {
        sound("sound.event.cashInTreasureTrain");
        unitWas.fireChanges();
        updateGUI(tile);
    }
    return ret;
}