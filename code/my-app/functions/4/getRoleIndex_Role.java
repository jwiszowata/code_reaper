public int getRoleIndex() {
    int base = (requiresAbility(Ability.NATIVE)) ? 30 : (requiresAbility(Ability.REF_UNIT)) ? 20 : 10;
    return base - getRequiredGoodsList().size();
}