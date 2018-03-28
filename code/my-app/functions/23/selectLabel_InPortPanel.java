public void selectLabel() {
    PortPanel portPanel = getPortPanel();
    if (portPanel == null)
        return;
    Unit selectedUnit = portPanel.getSelectedUnit();
    UnitLabel lastCarrier = null;
    for (Component component : getComponents()) {
        if (component instanceof UnitLabel) {
            UnitLabel label = (UnitLabel) component;
            Unit unit = label.getUnit();
            if (unit == selectedUnit) {
                portPanel.setSelectedUnitLabel(label);
                return;
            }
            if (unit.isCarrier() && unit.getTradeRoute() == null) {
                lastCarrier = label;
            }
        }
    }
    if (lastCarrier != null) {
        portPanel.setSelectedUnitLabel(lastCarrier);
    }
}