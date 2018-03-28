public Colony getColony(Game game) {
    return game.getFreeColGameObject(colonyId, Colony.class);
}