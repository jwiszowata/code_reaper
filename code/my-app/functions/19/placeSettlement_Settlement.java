public void placeSettlement(boolean maximal) {
    List<Tile> tiles;
    if (maximal) {
        tiles = owner.getClaimableTiles(tile, getRadius());
    } else {
        tiles = new ArrayList<>();
        tiles.add(tile);
    }
    tile.setSettlement(this);
    for (Tile t : tiles) {
        t.changeOwnership(owner, this);
    }
    if (!tile.hasRoad()) {
        TileImprovement road = tile.addRoad();
        road.setTurnsToComplete(0);
        road.setVirtual(true);
        road.updateRoadConnections(true);
    }
}