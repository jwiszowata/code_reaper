public boolean moveTileCursor(Direction direction) {
    if (direction == null)
        return false;
    final Tile tile = getGUI().getSelectedTile();
    if (tile == null)
        return false;
    final Tile newTile = tile.getNeighbourOrNull(direction);
    if (newTile == null)
        return false;
    getGUI().setSelectedTile(newTile);
    return true;
}