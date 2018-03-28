public List<CombatResult> generateAttackResult(Random random, FreeColGameObject attacker, FreeColGameObject defender) {
    LogBuilder lb = new LogBuilder(256);
    lb.add("Combat");
    ArrayList<CombatResult> crs = new ArrayList<>();
    CombatOdds odds = calculateCombatOdds(attacker, defender, lb);
    double r = randomDouble(logger, "AttackResult", random);
    lb.add(" random(1.0)=", r);
    boolean great = false;
    String action;
    if (combatIsAttack(attacker, defender)) {
        Unit attackerUnit = (Unit) attacker;
        Unit defenderUnit = (Unit) defender;
        action = "Attack";
        if (r < odds.win || defenderUnit.isBeached()) {
            great = r < 0.1 * odds.win;
            crs.add(CombatResult.WIN);
            resolveAttack(attackerUnit, defenderUnit, great, r / (0.1 * odds.win), crs);
        } else if (r < 0.8 * odds.win + 0.2 && defenderUnit.hasAbility(Ability.EVADE_ATTACK)) {
            crs.add(CombatResult.NO_RESULT);
            crs.add(CombatResult.EVADE_ATTACK);
        } else {
            great = r >= 0.1 * odds.win + 0.9;
            crs.add(CombatResult.LOSE);
            resolveAttack(defenderUnit, attackerUnit, great, (1.25 * r - 0.25 - odds.win) / (1.0 - odds.win), crs);
        }
    } else if (combatIsBombard(attacker, defender)) {
        Unit defenderUnit = (Unit) defender;
        if (!defenderUnit.isNaval()) {
            throw new IllegalStateException("Bombard of non-naval");
        }
        action = "Bombard";
        if (r <= odds.win) {
            crs.add(CombatResult.WIN);
            double offencePower = getOffencePower(attacker, defender);
            double defencePower = getDefencePower(attacker, defender);
            double diff = Math.max(3.0, defencePower * 2.0 - offencePower);
            great = r < odds.win / diff;
            if (great || defenderUnit.getRepairLocation() == null) {
                crs.add(CombatResult.SINK_SHIP_BOMBARD);
            } else {
                crs.add(CombatResult.DAMAGE_SHIP_BOMBARD);
            }
        } else {
            crs.add(CombatResult.NO_RESULT);
            crs.add(CombatResult.EVADE_BOMBARD);
        }
    } else {
        throw new IllegalStateException("Bogus combat");
    }
    lb.add(" great=", great, " ", action);
    for (CombatResult cr : crs) lb.add(" ", cr);
    lb.log(logger, Level.INFO);
    return crs;
}