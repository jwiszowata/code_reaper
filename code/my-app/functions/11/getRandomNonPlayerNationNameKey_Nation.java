public static String getRandomNonPlayerNationNameKey(Game game, Random random) {
    int nations = EUROPEAN_NATIONS.size();
    int start = randomInt(logger, "Random nation", random, nations);
    for (int index = 0; index < nations; index++) {
        String nationId = "model.nation." + EUROPEAN_NATIONS.get((start + index) % nations);
        if (game.getPlayerByNationId(nationId) == null) {
            return Messages.nameKey(nationId);
        }
    }
    return "";
}