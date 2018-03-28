public Colony getColony(Player player) {
    return player.getOurFreeColGameObject(getStringAttribute(COLONY_TAG), Colony.class);
}