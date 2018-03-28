private void colonyPanel(Colony colony, Unit unit) {
    getGUI().showColonyPanel(colony, (unit.isCarrier()) ? unit : null);
}