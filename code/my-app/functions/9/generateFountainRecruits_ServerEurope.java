public void generateFountainRecruits(int n, Random random) {
    final Game game = getGame();
    final Player owner = getOwner();
    List<RandomChoice<UnitType>> recruits = generateRecruitablesList();
    for (int k = 0; k < n; k++) {
        UnitType ut = RandomChoice.getWeightedRandom(logger, "Choose FoY", recruits, random);
        new ServerUnit(game, this, owner, ut);
    }
}