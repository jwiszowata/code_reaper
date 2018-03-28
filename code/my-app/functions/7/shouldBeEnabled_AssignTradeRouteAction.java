protected boolean shouldBeEnabled() {
    if (super.shouldBeEnabled()) {
        Unit unit = getGUI().getActiveUnit();
        return (unit != null && unit.isCarrier());
    }
    return false;
}