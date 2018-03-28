public Direction getDirection(Tile t1, Tile t2) {
    return (t1 == null || t2 == null) ? null : new Position(t1).getDirection(new Position(t2));
}