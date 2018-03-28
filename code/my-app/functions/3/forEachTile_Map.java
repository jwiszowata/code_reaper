public void forEachTile(Consumer<Tile> consumer) {
    forEachTile(alwaysTrue(), consumer);
}