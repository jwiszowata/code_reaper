public int getImmigration(int production) {
    final Specification spec = getSpecification();
    int n = count(getUnits(), Unit::isPerson);
    n *= spec.getInteger(GameOptions.EUROPEAN_UNIT_IMMIGRATION_PENALTY);
    n += spec.getInteger(GameOptions.PLAYER_IMMIGRATION_BONUS);
    if (n + production < 0)
        n = -production;
    return n;
}