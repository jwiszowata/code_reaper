private void setLand(int x, int y, int distanceToEdge, Random random) {
    if (!setLand(x, y))
        return;
    Position p = new Position(x, y);
    for (Direction direction : Direction.longSides) {
        Position n = new Position(p, direction);
        if (n.isValid(getWidth(), getHeight())) {
            growLand(n.getX(), n.getY(), distanceToEdge, random);
        }
    }
}