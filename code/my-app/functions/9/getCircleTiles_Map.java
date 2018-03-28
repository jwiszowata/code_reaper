public Iterable<Tile> getCircleTiles(final Tile center, final boolean isFilled, final int radius) {
    return new Iterable<Tile>() {

        @Override
        public Iterator<Tile> iterator() {
            return getCircleIterator(center, isFilled, radius);
        }
    };
}