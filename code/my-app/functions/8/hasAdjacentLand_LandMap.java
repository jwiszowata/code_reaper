private boolean hasAdjacentLand(int x, int y) {
    final Position p = new Position(x, y);
    final Predicate<Direction> landPred = d -> {
        Position n = new Position(p, d);
        return isLand(n.getX(), n.getY());
    };
    return any(Direction.values(), landPred);
}