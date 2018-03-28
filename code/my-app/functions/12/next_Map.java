public Tile next() throws NoSuchElementException {
    if (!hasNext()) {
        throw new NoSuchElementException("WholeMapIterator exhausted");
    }
    Tile result = getTile(x, y);
    x++;
    if (x >= getWidth()) {
        x = 0;
        y++;
    }
    return result;
}