private boolean isTileVisible(Tile tile) {
    if (tile == null)
        return false;
    return tile.getY() >= topRow && tile.getY() <= bottomRow && tile.getX() >= leftColumn && tile.getX() <= rightColumn;
}