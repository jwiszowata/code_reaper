public Tile getTileToCache() {
    Tile tile = this.copy(getGame());
    tile.clearUnitList();
    Colony colony = getColony();
    if (colony != null) {
        tile.getColony().setDisplayUnitCount(Math.min(1, colony.getUnitCount()));
    }
    return tile;
}