Rectangle calculateTileBounds(Tile tile) {
    Rectangle result = new Rectangle(0, 0, size.width, size.height);
    if (isTileVisible(tile)) {
        result.x = ((tile.getX() - leftColumn) * tileWidth) + leftColumnX;
        result.y = ((tile.getY() - topRow) * halfHeight) + topRowY - tileHeight;
        if ((tile.getY() & 1) != 0) {
            result.x += halfWidth;
        }
        result.width = tileWidth;
        result.height = tileHeight * 2;
    }
    return result;
}