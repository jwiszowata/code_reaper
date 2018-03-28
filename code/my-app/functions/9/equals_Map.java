public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof Position) {
        Position p = (Position) o;
        return x == p.x && y == p.y;
    }
    return false;
}