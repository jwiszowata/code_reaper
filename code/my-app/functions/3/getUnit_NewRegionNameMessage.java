public Unit getUnit(Player player) {
    return player.getOurFreeColGameObject(getStringAttribute(UNIT_TAG), Unit.class);
}