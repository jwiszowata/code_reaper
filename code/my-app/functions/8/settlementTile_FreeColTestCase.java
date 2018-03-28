public IndianSettlementBuilder settlementTile(Tile tile) {
    Tile tileOnMap = this.game.getMap().getTile(tile.getX(), tile.getY());
    if (tile != tileOnMap) {
        throw new IllegalArgumentException("Given tile not on map");
    }
    this.settlementTile = tile;
    return this;
}