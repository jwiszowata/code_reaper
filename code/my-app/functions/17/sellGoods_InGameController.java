public boolean sellGoods(Goods goods) {
    if (!requireOurTurn() || goods == null || !(goods.getLocation() instanceof Unit))
        return false;
    final Player player = getMyPlayer();
    Unit carrier = (Unit) goods.getLocation();
    Europe europe = player.getEurope();
    EuropeWas europeWas = new EuropeWas(europe);
    UnitWas unitWas = new UnitWas(carrier);
    boolean ret = askUnloadGoods(goods.getType(), goods.getAmount(), carrier);
    if (ret) {
        sound("sound.event.sellCargo");
        europeWas.fireChanges();
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}