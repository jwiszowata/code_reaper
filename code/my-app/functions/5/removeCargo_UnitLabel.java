public void removeCargo(Component comp, CargoPanel cargoPanel) {
    Unit unit = ((UnitLabel) comp).getUnit();
    cargoPanel.igc().leaveShip(unit);
    cargoPanel.update();
}