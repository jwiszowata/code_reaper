private static int scoreUnit(AIUnit aiUnit, Unit defender) {
    final Unit attacker = aiUnit.getUnit();
    int value = 100;
    value += defender.getVisibleGoodsCount() * 200;
    if (defender.isOffensiveUnit()) {
        CombatModel.CombatOdds co = attacker.getGame().getCombatModel().calculateCombatOdds(attacker, defender);
        if (co != null)
            value += (co.win - 0.5) * 200;
    }
    return value;
}