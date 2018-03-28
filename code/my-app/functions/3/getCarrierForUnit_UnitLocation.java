public Unit getCarrierForUnit(Unit unit) {
    return find(getUnits(), u -> u.couldCarry(unit));
}