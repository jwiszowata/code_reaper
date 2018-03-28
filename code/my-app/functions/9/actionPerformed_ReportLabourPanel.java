public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (FreeColPanel.OK.equals(command)) {
        super.actionPerformed(ae);
    } else {
        UnitType unitType = getSpecification().getUnitType(command);
        getGUI().showReportLabourDetailPanel(unitType, this.data, this.unitCount, this.colonies);
    }
}