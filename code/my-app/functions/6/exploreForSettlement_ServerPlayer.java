public Set<Tile> exploreForSettlement(Settlement settlement) {
    Set<Tile> tiles = new HashSet<>(settlement.getOwnedTiles());
    tiles.addAll(settlement.getVisibleTiles());
    tiles.remove(settlement.getTile());
    return exploreTiles(tiles);
}