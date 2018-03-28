public FreeColGameObject getParent(Game game) {
    return game.getFreeColGameObject(getStringAttribute(ID_TAG));
}