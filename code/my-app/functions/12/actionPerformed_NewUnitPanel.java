public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();
    if (OK.equals(command)) {
        super.actionPerformed(ae);
    } else {
        UnitType unitType = getSpecification().getUnitType(command);
        igc().trainUnitInEurope(unitType);
        getGUI().updateEuropeanSubpanels();
        if (!shouldEnable)
            getGUI().removeFromCanvas(this);
    }
}