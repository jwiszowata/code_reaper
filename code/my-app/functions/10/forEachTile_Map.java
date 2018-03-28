public void forEachTile(Predicate<Tile> predicate, Consumer<Tile> consumer) {
    final int hgt = getHeight(), wid = getWidth();
    for (int y = 0; y < hgt; y++) {
        for (int x = 0; x < wid; x++) {
            if (predicate.test(this.tiles[x][y])) {
                consumer.accept(this.tiles[x][y]);
            }
        }
    }
}