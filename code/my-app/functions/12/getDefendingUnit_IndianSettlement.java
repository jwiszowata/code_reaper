public Unit getDefendingUnit(Unit attacker) {
    Unit defender = null;
    double defencePower = -1.0;
    for (Unit nextUnit : getUnitList()) {
        double unitPower = attacker.getGame().getCombatModel().getDefencePower(attacker, nextUnit);
        if (Unit.betterDefender(defender, defencePower, nextUnit, unitPower)) {
            defender = nextUnit;
            defencePower = unitPower;
        }
    }
    return defender;
}