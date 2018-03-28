public Unit getDefender(Game game) {
    return game.getFreeColGameObject(getStringAttribute(DEFENDER_TAG), Unit.class);
}