public Tile getCenterTile(Map map) {
    if (tile != null)
        return tile;
    int[] xy = region.getCenter();
    return map.getTile(xy[0], xy[1]);
}