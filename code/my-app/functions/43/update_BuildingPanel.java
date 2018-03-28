public void update() {
    removeAll();
    unitLabels.clear();
    final Colony colony = building.getColony();
    ProductionLabel productionOutput = null;
    ProductionInfo info = building.getProductionInfo();
    AbstractGoods output = (info == null) ? null : first(info.getProduction());
    if (output != null && output.getAmount() > 0) {
        if (building.hasAbility(Ability.AVOID_EXCESS_PRODUCTION)) {
            int stored = colony.getGoodsCount(output.getType());
            int capacity = colony.getWarehouseCapacity();
            if (output.getAmount() + stored > capacity) {
                output = new AbstractGoods(output.getType(), capacity - stored);
            }
        }
        AbstractGoods maximum = info.getMaximumProduction().isEmpty() ? output : info.getMaximumProduction().get(0);
        productionOutput = new ProductionLabel(freeColClient, output, maximum.getAmount());
    }
    JLabel upkeep = null;
    if (building.getSpecification().getBoolean(GameOptions.ENABLE_UPKEEP) && building.getType().getUpkeep() > 0) {
        upkeep = new UpkeepLabel(building.getType().getUpkeep());
    }
    if (productionOutput == null) {
        if (upkeep != null) {
            add(upkeep, "span, align center");
        }
    } else if (upkeep == null) {
        add(productionOutput, "span, align center");
    } else {
        add(productionOutput, "span, split 2, align center");
        add(upkeep);
    }
    for (Unit unit : building.getUnitList()) {
        UnitLabel unitLabel = new UnitLabel(freeColClient, unit, true);
        unitLabels.add(unitLabel);
        add(unitLabel);
    }
    ImageLibrary lib = freeColClient.getGUI().getImageLibrary();
    Image buildingImage = lib.getBuildingImage(building);
    setPreferredSize(new Dimension(buildingImage.getWidth(null), buildingImage.getHeight(null)));
    revalidate();
    repaint();
}