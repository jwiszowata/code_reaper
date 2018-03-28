private Settlement getSettlementAt(Tile tile, Direction direction) {
    return tile.getNeighbourOrNull(direction).getSettlement();
}