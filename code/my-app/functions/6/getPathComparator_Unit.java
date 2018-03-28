public Comparator<Tile> getPathComparator(final Location start, final Unit carrier, final CostDecider costDecider) {
    return cachingIntComparator((Tile t) -> {
        PathNode p = this.findPath(start, t, carrier, costDecider);
        return (p == null) ? INFINITY : p.getTotalTurns();
    });
}