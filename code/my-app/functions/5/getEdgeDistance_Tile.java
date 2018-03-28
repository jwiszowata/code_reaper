private int getEdgeDistance() {
    final Map map = getMap();
    final int x = getX(), y = getY();
    return Math.min(Math.min(x, map.getWidth() - x), Math.min(y, map.getHeight() - y));
}