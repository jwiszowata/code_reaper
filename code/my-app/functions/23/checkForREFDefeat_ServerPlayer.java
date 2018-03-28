public boolean checkForREFDefeat() {
    if (!isREF())
        return false;
    if (getRebels().isEmpty())
        return false;
    if (hasSettlements())
        return false;
    final int landREFUnitsRequired = 7;
    boolean naval = false;
    int land = 0;
    for (Unit u : getUnitList()) {
        if (u.isNaval())
            naval = true;
        else {
            if (u.hasAbility(Ability.REF_UNIT))
                land++;
        }
    }
    if (naval && land >= landREFUnitsRequired)
        return false;
    final double power = calculateStrength(false);
    return all(getRebels(), r -> r.calculateStrength(false) > power);
}