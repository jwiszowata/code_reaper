public Unit getAttacker(Game game) {
    return game.getFreeColGameObject(getStringAttribute(ATTACKER_TAG), Unit.class);
}