public List<Unit> getCarriersForUnit(Unit unit) {
    return transform(getUnits(), u -> u.couldCarry(unit));
}