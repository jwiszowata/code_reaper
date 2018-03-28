public static boolean[][] floodFill(boolean[][] boolmap, int x, int y, int limit) {
    final int xmax = boolmap.length, ymax = boolmap[0].length;
    boolean[][] visited = new boolean[xmax][ymax];
    Queue<Position> q = new LinkedList<>();
    visited[x][y] = true;
    for (Position p = new Position(x, y); p != null && --limit > 0; p = q.poll()) {
        for (Direction d : Direction.values()) {
            final Position np = new Position(p, d);
            if (np.isValid(xmax, ymax) && boolmap[np.getX()][np.getY()] && !visited[np.getX()][np.getY()]) {
                visited[np.getX()][np.getY()] = true;
                q.add(np);
            }
        }
    }
    return visited;
}