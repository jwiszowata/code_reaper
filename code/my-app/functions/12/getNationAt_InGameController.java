private StringTemplate getNationAt(Tile tile, Direction direction) {
    Tile newTile = tile.getNeighbourOrNull(direction);
    Player player = null;
    if (newTile.hasSettlement()) {
        player = newTile.getSettlement().getOwner();
    } else if (newTile.getFirstUnit() != null) {
        player = newTile.getFirstUnit().getOwner();
    } else {
        player = getGame().getUnknownEnemy();
    }
    return player.getNationLabel();
}