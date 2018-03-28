public boolean setSelectedUnit(Unit unit) {
    return ((unit.isCarrier()) ? inPortPanel.setSelectedUnit(unit) : super.setSelectedUnit(unit));
}