public void initialize() {
    if (isOverview()) {
        showProduction = true;
        showNetProduction = true;
        showProductionSymbols = true;
        showBuildings = false;
    } else {
        showProduction = unitData.showProduction();
        showNetProduction = unitData.showNetProduction();
        showProductionSymbols = false;
        GoodsType expertProduction = getGoodsType();
        showBuildings = (expertProduction != null && !expertProduction.isFarmed()) || unitData.getTotal().isTraining();
    }
    String layoutConstraints = "fill, insets 0, gap 0 0";
    StringBuilder widths = new StringBuilder();
    widths.append("[175, fill]");
    widths.append(isOverview() || !unitData.isSummary() ? "[150, fill]" : "[0!]");
    widths.append("[150, fill]");
    widths.append(showBuildings ? "[130, fill]" : "[0!]");
    widths.append("[26, fill][33, fill]");
    widths.append(showProductionSymbols ? "[50, fill]" : "[0!]");
    widths.append(showProduction ? "[30, fill][40, fill]" : "[0!][0!]");
    widths.append(showNetProduction ? "[40, fill]" : "[0!]");
    String columnConstraints = widths.toString();
    String rowConstraints = "[fill]";
    headerRow.setLayout(new MigLayout(layoutConstraints, columnConstraints, rowConstraints));
    reportPanel.setLayout(new MigLayout(layoutConstraints, columnConstraints, rowConstraints));
    addHeader();
    if (isOverview()) {
        addUnitTypes();
    } else {
        addLocations();
    }
}