public void exciseSettlement() {
    Tile settlementTile = getTile();
    for (Tile tile : getOwnedTiles()) {
        tile.changeOwnership(null, null);
    }
    settlementTile.setSettlement(null);
    settlementTile.changeOwnership(null, null);
    TileImprovement road = settlementTile.getRoad();
    if (road != null && road.isVirtual()) {
        settlementTile.removeRoad();
    }
}