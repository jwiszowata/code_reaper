public int getNumberOfKingLandUnits() {
    return count(getUnits(), u -> u.hasAbility(Ability.REF_UNIT) && !u.isNaval());
}