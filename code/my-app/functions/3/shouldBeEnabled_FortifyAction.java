protected boolean shouldBeEnabled() {
    return super.shouldBeEnabled() && getGUI().getActiveUnit().checkSetState(Unit.UnitState.FORTIFYING);
}