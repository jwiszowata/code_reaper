public void updateNetProductionPanel() {
    final Colony colony = getColony();
    final Specification spec = colony.getSpecification();
    colony.invalidateCache();
    netProductionPanel.removeAll();
    for (GoodsType goodsType : spec.getGoodsTypeList()) {
        int amount = colony.getAdjustedNetProductionOf(goodsType);
        if (amount != 0) {
            netProductionPanel.add(new ProductionLabel(getFreeColClient(), new AbstractGoods(goodsType, amount)));
        }
    }
    netProductionPanel.revalidate();
}