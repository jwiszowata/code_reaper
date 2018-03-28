public static Direction getRoughDirection(Tile src, Tile dst) {
    int x = dst.getX() - src.getX();
    int y = dst.getY() - src.getY();
    if (x == 0 && y == 0)
        return null;
    double theta = Math.atan2(y, x) + Math.PI / 2 + Math.PI / 8;
    if (theta < 0)
        theta += 2 * Math.PI;
    return Direction.angleToDirection(theta);
}