void displayUnknownTileBorder(Graphics2D g, Tile tile) {
    for (Direction direction : Direction.values()) {
        Tile borderingTile = tile.getNeighbourOrNull(direction);
        if (borderingTile != null && !borderingTile.isExplored()) {
            g.drawImage(lib.getBorderImage(null, direction, tile.getX(), tile.getY()), 0, 0, null);
        }
    }
}