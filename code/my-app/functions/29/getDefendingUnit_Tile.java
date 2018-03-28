public Unit getDefendingUnit(Unit attacker) {
    CombatModel cm = getGame().getCombatModel();
    Unit defender = null;
    double defenderPower = -1.0, power;
    for (Unit u : transform(getUnits(), u -> isLand() != u.isNaval())) {
        power = cm.getDefencePower(attacker, u);
        if (Unit.betterDefender(defender, defenderPower, u, power)) {
            defender = u;
            defenderPower = power;
        }
    }
    if ((defender == null || !defender.isDefensiveUnit()) && hasSettlement()) {
        Unit u = null;
        try {
            u = settlement.getDefendingUnit(attacker);
        } catch (IllegalStateException e) {
            logger.log(Level.WARNING, "Empty settlement: " + settlement.getName(), e);
        }
        if (u != null) {
            power = cm.getDefencePower(attacker, u);
            if (Unit.betterDefender(defender, defenderPower, u, power)) {
                defender = u;
            }
        }
    }
    if (defender == null && isLand())
        defender = getFirstUnit();
    return defender;
}