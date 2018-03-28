public void actionPerformed(ActionEvent ae) {
    final Unit unit = getGUI().getActiveUnit();
    if (unit == null)
        return;
    if (unit.getState() != Unit.UnitState.SKIPPED) {
        igc().changeState(unit, Unit.UnitState.SKIPPED);
    }
    if (unit.getState() == Unit.UnitState.SKIPPED) {
        igc().nextActiveUnit();
    }
}