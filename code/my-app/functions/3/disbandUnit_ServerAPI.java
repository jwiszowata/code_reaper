public boolean disbandUnit(Unit unit) {
    return ask(unit.getGame(), new DisbandUnitMessage(unit));
}