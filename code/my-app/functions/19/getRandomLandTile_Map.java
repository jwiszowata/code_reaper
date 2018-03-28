public Tile getRandomLandTile(Random random) {
    final int SLOSH = 10;
    int x = 0, y = 0, width = getWidth(), height = getHeight();
    if (width >= SLOSH) {
        width -= SLOSH;
        x += SLOSH / 2;
    }
    if (height >= SLOSH) {
        height -= SLOSH;
        y += SLOSH / 2;
    }
    x += randomInt(logger, "W", random, width);
    y += randomInt(logger, "H", random, height);
    for (Tile t : getCircleTiles(getTile(x, y), true, INFINITY)) {
        if (t.isLand())
            return t;
    }
    return null;
}