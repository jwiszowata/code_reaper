public Tile getLandWithinDistance(int x, int y, int distance) {
    for (Tile t : getCircleTiles(getTile(x, y), true, distance)) {
        if (t.isLand())
            return t;
    }
    return null;
}