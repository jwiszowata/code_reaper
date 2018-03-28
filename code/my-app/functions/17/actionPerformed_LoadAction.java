public void actionPerformed(ActionEvent ae) {
    final Unit unit = getGUI().getActiveUnit();
    if (unit == null)
        return;
    final Colony colony = unit.getColony();
    if (colony == null)
        return;
    for (Goods goods : unit.getCompactGoodsList()) {
        final GoodsType type = goods.getType();
        int loadable = unit.getLoadableAmount(type);
        int present = colony.getGoodsCount(type);
        if (loadable > 0 && present > 0) {
            int n = Math.min(Math.min(loadable, present), GoodsContainer.CARGO_SIZE);
            igc().loadCargo(new Goods(goods.getGame(), colony, type, n), unit);
        }
    }
}