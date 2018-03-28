private void restoreSelection(UnitLabel oldSelectedUnit) {
    if (oldSelectedUnit != null && oldSelectedUnit.getParent() instanceof InPortPanel) {
        ((PortPanel) parentPanel).setSelectedUnitLabel(oldSelectedUnit);
    }
}