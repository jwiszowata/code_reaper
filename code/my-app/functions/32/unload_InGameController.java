public boolean unload(Unit unit) {
    if (!requireOurTurn() || unit == null || !unit.isCarrier())
        return false;
    boolean ret = true;
    Colony colony = unit.getColony();
    if (colony != null) {
        for (Unit u : unit.getUnitList()) {
            ret = leaveShip(u) && ret;
        }
        for (Goods goods : unit.getGoodsList()) {
            ret = unloadCargo(goods, false) && ret;
        }
    } else if (unit.isInEurope()) {
        final Player player = getMyPlayer();
        for (Goods goods : unit.getCompactGoodsList()) {
            if (player.canTrade(goods.getType())) {
                ret = sellGoods(goods) && ret;
            }
        }
        if (unit.hasGoodsCargo()) {
            getGUI().showDumpCargoDialog(unit, (List<Goods> goodsList) -> {
                for (Goods g : goodsList) unloadCargo(g, true);
            });
            return false;
        }
    } else {
        for (Goods goods : unit.getGoodsList()) {
            ret = unloadCargo(goods, false) && ret;
        }
    }
    return ret;
}