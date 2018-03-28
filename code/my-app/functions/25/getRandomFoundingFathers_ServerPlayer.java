public List<FoundingFather> getRandomFoundingFathers(Random random) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final int age = game.getAge();
    EnumMap<FoundingFatherType, List<RandomChoice<FoundingFather>>> choices = new EnumMap<>(FoundingFatherType.class);
    for (FoundingFather father : transform(spec.getFoundingFathers(), ff -> !hasFather(ff) && ff.isAvailableTo(this))) {
        FoundingFatherType type = father.getType();
        List<RandomChoice<FoundingFather>> rc = choices.get(type);
        if (rc == null)
            rc = new ArrayList<>();
        int weight = father.getWeight(age);
        rc.add(new RandomChoice<>(father, weight));
        choices.put(father.getType(), rc);
    }
    final Function<FoundingFatherType, FoundingFather> mapper = ft -> {
        List<RandomChoice<FoundingFather>> rc = choices.get(ft);
        return (rc == null) ? null : RandomChoice.getWeightedRandom(logger, "Choose founding father", rc, random);
    };
    List<FoundingFather> fathers = transform(FoundingFatherType.values(), alwaysTrue(), mapper, toListNoNulls());
    LogBuilder lb = new LogBuilder(64);
    lb.add("Random fathers for ", getDebugName(), ":");
    for (FoundingFather f : fathers) lb.add(" ", f.getSuffix());
    lb.log(logger, Level.INFO);
    return fathers;
}