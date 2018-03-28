private void sailAction() {
    Unit unit = getSelectedUnit();
    if (unit != null && unit.isNaval()) {
        UnitLabel unitLabel = getSelectedUnitLabel();
        toAmericaPanel.add(unitLabel, true);
    }
    requestFocus();
}