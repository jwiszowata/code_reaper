public void resetContiguity() {
    final int xmax = getWidth(), ymax = getHeight();
    boolean[][] waterMap = new boolean[xmax][ymax];
    for (int y = 0; y < ymax; y++) {
        for (int x = 0; x < xmax; x++) {
            if (isValid(x, y)) {
                waterMap[x][y] = !getTile(x, y).isLand();
                Tile tile = getTile(x, y);
                tile.setContiguity(-1);
            }
        }
    }
    int contig = 0;
    floodFill(contig, ymax, xmax, waterMap);
    for (int y = 0; y < ymax; y++) {
        for (int x = 0; x < xmax; x++) {
            if (isValid(x, y))
                waterMap[x][y] = !waterMap[x][y];
        }
    }
    floodFill(contig, ymax, xmax, waterMap);
}