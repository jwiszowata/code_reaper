public Unit getUnit(Game game) {
    return game.getFreeColGameObject(getStringAttribute(UNIT_TAG), Unit.class);
}