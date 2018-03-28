private static int fillOcean(Map map, Tile tile, ServerRegion region, Rectangle bounds) {
    Queue<Tile> q = new LinkedList<>();
    int n = 0;
    boolean[][] visited = new boolean[map.getWidth()][map.getHeight()];
    visited[tile.getX()][tile.getY()] = true;
    q.add(tile);
    while ((tile = q.poll()) != null) {
        region.addTile(tile);
        n++;
        for (Direction direction : Direction.values()) {
            Tile t = map.getAdjacentTile(tile, direction);
            if (t != null && !visited[t.getX()][t.getY()] && bounds.contains(t.getX(), t.getY())) {
                visited[t.getX()][t.getY()] = true;
                if ((t.getRegion() == null || t.getRegion() == region) && !t.isLand()) {
                    q.add(t);
                }
            }
        }
    }
    return n;
}