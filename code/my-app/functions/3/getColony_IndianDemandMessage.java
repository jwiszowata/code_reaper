public Colony getColony(Game game) {
    return game.getFreeColGameObject(getStringAttribute(COLONY_TAG), Colony.class);
}