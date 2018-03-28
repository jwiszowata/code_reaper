Point calculateTilePosition(Tile t) {
    repositionMapIfNeeded();
    if (!isTileVisible(t))
        return null;
    int x = ((t.getX() - leftColumn) * tileWidth) + leftColumnX;
    int y = ((t.getY() - topRow) * halfHeight) + topRowY;
    if ((t.getY() & 1) != 0)
        x += halfWidth;
    return new Point(x, y);
}