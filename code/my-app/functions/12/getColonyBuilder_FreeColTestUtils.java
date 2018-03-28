public static ColonyBuilder getColonyBuilder() {
    Game game = FreeColTestCase.getGame();
    if (game == null) {
        throw new NullPointerException("Game not set");
    }
    if (colonyBuilder == null) {
        colonyBuilder = new ColonyBuilder(game);
    } else {
        colonyBuilder = colonyBuilder.reset().setGame(game);
    }
    return colonyBuilder;
}