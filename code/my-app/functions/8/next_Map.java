public Tile next() throws NoSuchElementException {
    if (!hasNext()) {
        throw new NoSuchElementException("CircleIterator exhausted");
    }
    Tile result = getTile(x, y);
    nextTile();
    return result;
}