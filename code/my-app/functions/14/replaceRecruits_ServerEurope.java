public boolean replaceRecruits(Random random) {
    List<RandomChoice<UnitType>> recruits = generateRecruitablesList();
    boolean result = false;
    int i = 0;
    for (UnitType ut : recruitables) {
        if (hasAbility(Ability.CAN_RECRUIT_UNIT, ut))
            continue;
        UnitType newType = RandomChoice.getWeightedRandom(logger, "Replace recruit", recruits, random);
        recruitables.set(i, newType);
        result = true;
        i++;
    }
    return result;
}