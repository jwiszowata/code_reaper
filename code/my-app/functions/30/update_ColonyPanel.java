public void update() {
    removeAll();
    if (this.colonyTile == null) {
        logger.warning("Update of " + getColony() + " null colony tile.");
        return;
    }
    final FreeColClient fcc = getFreeColClient();
    UnitLabel label = null;
    for (Unit unit : this.colonyTile.getUnitList()) {
        label = new UnitLabel(fcc, unit, false, false, true);
        if (ColonyPanel.this.isEditable()) {
            label.setTransferHandler(defaultTransferHandler);
            label.addMouseListener(pressListener);
        }
        super.add(label);
    }
    updateDescriptionLabel(label);
    if (this.colonyTile.isColonyCenterTile()) {
        setLayout(new GridLayout(2, 1));
        final ImageLibrary til = getGUI().getTileImageLibrary();
        ProductionInfo info = colony.getProductionInfo(this.colonyTile);
        if (info != null) {
            for (AbstractGoods ag : info.getProduction()) {
                ProductionLabel productionLabel = new ProductionLabel(fcc, til, ag);
                productionLabel.addMouseListener(pressListener);
                add(productionLabel);
            }
        }
    }
}