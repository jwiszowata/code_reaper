public boolean setSelectedUnit(Unit unit) {
    for (Component component : getComponents()) {
        if (component instanceof UnitLabel) {
            UnitLabel label = (UnitLabel) component;
            if (label.getUnit() == unit) {
                setSelectedUnitLabel(label);
                return true;
            }
        }
    }
    return false;
}