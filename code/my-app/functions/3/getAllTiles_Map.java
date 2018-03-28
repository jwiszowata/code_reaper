public Stream<Tile> getAllTiles() {
    return toStream(new WholeMapIterator());
}