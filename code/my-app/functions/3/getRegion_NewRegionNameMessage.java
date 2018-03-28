public Region getRegion(Game game) {
    return game.getFreeColGameObject(getStringAttribute(REGION_TAG), Region.class);
}