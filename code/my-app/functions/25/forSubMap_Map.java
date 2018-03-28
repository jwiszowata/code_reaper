public void forSubMap(int x, int y, int w, int h, Consumer<Tile> consumer) {
    if (x < 0) {
        w += x;
        x = 0;
    }
    if (y < 0) {
        h += y;
        y = 0;
    }
    if (w <= 0 || h <= 0)
        return;
    int width = getWidth();
    int height = getHeight();
    if (x > width || y > height)
        return;
    if (x + w > width)
        w = width - x;
    if (y + h > height)
        h = height - y;
    for (int yi = y; yi < y + h; ++yi) {
        for (int xi = x; xi < x + w; ++xi) {
            consumer.accept(this.tiles[xi][yi]);
        }
    }
}