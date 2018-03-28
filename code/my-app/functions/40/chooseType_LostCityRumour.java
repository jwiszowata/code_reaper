public RumourType chooseType(Unit unit, Random random) {
    final Specification spec = getSpecification();
    final Tile tile = getTile();
    final boolean allowLearn = unit != null && !spec.getUnitChanges(UnitChangeType.LOST_CITY, unit.getType()).isEmpty();
    int percentBad = spec.getInteger(GameOptions.BAD_RUMOUR);
    int percentGood = spec.getInteger(GameOptions.GOOD_RUMOUR);
    if (unit != null) {
        float mod = unit.applyModifiers(1.0f, getGame().getTurn(), Modifier.EXPLORE_LOST_CITY_RUMOUR);
        percentBad = Math.round(percentBad * mod);
        percentGood = Math.round(percentGood * mod);
    }
    if (unit != null && unit.getOwner().hasAbility(Ability.RUMOURS_ALWAYS_POSITIVE)) {
        percentBad = 0;
        percentGood = 100;
    }
    int percentNeutral = Math.max(0, 100 - percentBad - percentGood);
    List<RandomChoice<RumourType>> c = new ArrayList<>();
    if (allowLearn) {
        c.add(new RandomChoice<>(RumourType.LEARN, 30 * percentGood));
        c.add(new RandomChoice<>(RumourType.TRIBAL_CHIEF, 30 * percentGood));
        c.add(new RandomChoice<>(RumourType.COLONIST, 20 * percentGood));
    } else {
        c.add(new RandomChoice<>(RumourType.TRIBAL_CHIEF, 50 * percentGood));
        c.add(new RandomChoice<>(RumourType.COLONIST, 30 * percentGood));
    }
    if (unit == null || unit.getOwner().getPlayerType() == Player.PlayerType.COLONIAL) {
        c.add(new RandomChoice<>(RumourType.FOUNTAIN_OF_YOUTH, 2 * percentGood));
    }
    c.add(new RandomChoice<>(RumourType.MOUNDS, 8 * percentGood));
    c.add(new RandomChoice<>(RumourType.RUINS, 6 * percentGood));
    c.add(new RandomChoice<>(RumourType.CIBOLA, 4 * percentGood));
    if (tile.getOwner() != null && tile.getOwner().isIndian()) {
        c.add(new RandomChoice<>(RumourType.BURIAL_GROUND, 25 * percentBad));
        c.add(new RandomChoice<>(RumourType.EXPEDITION_VANISHES, 75 * percentBad));
    } else {
        c.add(new RandomChoice<>(RumourType.EXPEDITION_VANISHES, 100 * percentBad));
    }
    c.add(new RandomChoice<>(RumourType.NOTHING, 100 * percentNeutral));
    return RandomChoice.getWeightedRandom(logger, "Choose rumour", c, random);
}