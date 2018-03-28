public Iterator<Tile> getCircleIterator(Tile center, boolean isFilled, int radius) {
    return new CircleIterator(center, isFilled, radius);
}