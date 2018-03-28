public Iterator<Tile> iterator() {
    return getCircleIterator(center, isFilled, radius);
}