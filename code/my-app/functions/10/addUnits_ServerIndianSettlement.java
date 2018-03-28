public void addUnits(int count) {
    final Specification spec = getSpecification();
    final Game game = getGame();
    final UnitType brave = spec.getDefaultUnitType(getOwner());
    for (int i = 0; i < count; i++) {
        Unit unit = new ServerUnit(game, this, getOwner(), brave, brave.getDefaultRole());
        unit.changeHomeIndianSettlement(this);
        unit.setLocation(this);
    }
}