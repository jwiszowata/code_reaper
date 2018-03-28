private CombatOdds calculateCombatOdds(FreeColGameObject attacker, FreeColGameObject defender, LogBuilder lb) {
    if (attacker == null || defender == null) {
        if (lb != null)
            lb.add(" odds=unknowable");
        return new CombatOdds(CombatOdds.UNKNOWN_ODDS);
    }
    if (lb != null)
        lb.add(" attacker=", attacker, " ");
    double attackPower = getOffencePower(attacker, defender, lb);
    if (lb != null)
        lb.add(" defender=", defender, " ");
    double defencePower = getDefencePower(attacker, defender, lb);
    if (attackPower == 0.0 && defencePower == 0.0) {
        if (lb != null)
            lb.add(" odds=unknown");
        return new CombatOdds(CombatOdds.UNKNOWN_ODDS);
    }
    double victory = attackPower / (attackPower + defencePower);
    if (lb != null)
        lb.add(" odds=", victory);
    return new CombatOdds(victory);
}