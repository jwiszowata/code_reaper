public final void update() {
    super.update();
    final Unit unit = getGUI().getActiveUnit();
    if (unit != null && unit.hasTile()) {
        if (unit.getColony() != null) {
            putValue(NAME, Messages.getName("changeAction.enterColony"));
        } else if (unit.isOnCarrier()) {
            putValue(NAME, Messages.getName("changeAction.selectCarrier"));
        } else {
            putValue(NAME, Messages.getName("changeAction.nextUnitOnTile"));
        }
    }
}