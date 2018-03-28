private void unloadAction() {
    Unit unit = getSelectedUnit();
    if (unit != null && unit.isCarrier()) {
        for (Goods g : unit.getCompactGoodsList()) {
            if (getMyPlayer().canTrade(g.getType())) {
                igc().sellGoods(g);
            } else {
                igc().payArrears(g.getType());
            }
        }
        for (Unit u : unit.getUnitList()) {
            igc().leaveShip(u);
        }
        cargoPanel.update();
        docksPanel.update();
    }
    requestFocus();
}