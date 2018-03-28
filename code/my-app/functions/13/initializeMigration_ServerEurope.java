public void initializeMigration(Random random) {
    final Specification spec = getGame().getSpecification();
    UnitListOption option = (UnitListOption) spec.getOption(GameOptions.IMMIGRANTS);
    UnitType unitType;
    for (AbstractUnit au : option.getOptionValues()) {
        unitType = au.getType(spec);
        addRecruitable(au.getType(spec));
    }
    List<RandomChoice<UnitType>> recruits = generateRecruitablesList();
    do {
        unitType = RandomChoice.getWeightedRandom(logger, "Recruits", recruits, random);
    } while (addRecruitable(unitType));
}