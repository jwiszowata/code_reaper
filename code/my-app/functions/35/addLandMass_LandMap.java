private int addLandMass(int minSize, int maxSize, int x, int y, int distanceToEdge, Random random) {
    int size = 0;
    boolean[][] newLand = new boolean[getWidth()][getHeight()];
    if (x < 0 || y < 0) {
        final int wid = getWidth() - distanceToEdge * 2;
        final int hgt = getHeight() - distanceToEdge * 2;
        do {
            x = distanceToEdge + randomInt(logger, "LandW", random, wid);
            y = distanceToEdge + randomInt(logger, "LandH", random, hgt);
        } while (isLand(x, y) || hasAdjacentLand(x, y));
    }
    newLand[x][y] = true;
    size++;
    Position p = new Position(x, y);
    List<Position> l = newPositions(p, distanceToEdge);
    int enough = minSize + randomInt(logger, "LandSize", random, maxSize - minSize + 1);
    while (size < enough && !l.isEmpty()) {
        int i = randomInt(logger, "Lsiz", random, l.size());
        p = l.remove(i);
        if (!newLand[p.getX()][p.getY()]) {
            newLand[p.getX()][p.getY()] = true;
            size++;
            l.addAll(newPositions(p, distanceToEdge));
        }
    }
    if (size >= minSize) {
        for (x = 0; x < this.width; x++) {
            for (y = 0; y < this.height; y++) {
                if (newLand[x][y])
                    setLand(x, y);
            }
        }
    }
    return (size >= minSize) ? size : 0;
}