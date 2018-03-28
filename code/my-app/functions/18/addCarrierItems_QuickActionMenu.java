private boolean addCarrierItems(final UnitLabel unitLabel) {
    final Unit unit = unitLabel.getUnit();
    if (!unit.isCarrier() || !unit.hasCargo())
        return false;
    JMenuItem cargo = Utility.localizedMenuItem("cargoOnCarrier");
    this.add(cargo);
    for (Unit passenger : unit.getUnitList()) {
        JMenuItem menuItem = new JMenuItem("    " + passenger.getDescription(Unit.UnitLabelType.NATIONAL));
        menuItem.setFont(menuItem.getFont().deriveFont(Font.ITALIC));
        this.add(menuItem);
    }
    for (Goods goods : unit.getGoodsList()) {
        JMenuItem menuItem = new JMenuItem("    " + Messages.message(goods.getLabel(true)));
        menuItem.setFont(menuItem.getFont().deriveFont(Font.ITALIC));
        this.add(menuItem);
    }
    return true;
}