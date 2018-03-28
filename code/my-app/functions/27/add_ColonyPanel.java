public Component add(Component comp, boolean editState) {
    Container oldParent = comp.getParent();
    if (editState) {
        if (comp instanceof UnitLabel) {
            UnitLabel unitLabel = (UnitLabel) comp;
            Unit unit = unitLabel.getUnit();
            if (!unit.isOnCarrier()) {
                igc().putOutsideColony(unit);
            }
            if (unit.getColony() == null) {
                closeColonyPanel();
                return null;
            } else if (!(unit.getLocation() instanceof Tile) && !unit.isOnCarrier()) {
                return null;
            }
            oldParent.remove(comp);
            initialize();
            return comp;
        } else {
            logger.warning("Invalid component: " + comp);
            return null;
        }
    } else {
        ((UnitLabel) comp).setSmall(false);
        return add(comp);
    }
}