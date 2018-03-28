public Unit getUnit(Player player) {
    return player.getOurFreeColGameObject(this.unitId, Unit.class);
}