private void floodFill(int contig, int ymax, int xmax, boolean[][] waterMap) {
    for (int y = 0; y < ymax; y++) {
        for (int x = 0; x < xmax; x++) {
            if (waterMap[x][y]) {
                Tile tile = getTile(x, y);
                if (tile.getContiguity() >= 0)
                    continue;
                boolean[][] found = floodFill(waterMap, x, y);
                for (int yy = 0; yy < ymax; yy++) {
                    for (int xx = 0; xx < xmax; xx++) {
                        if (found[xx][yy]) {
                            Tile t = getTile(xx, yy);
                            if (t.getContiguity() < 0) {
                                t.setContiguity(contig);
                            }
                        }
                    }
                }
                contig++;
            }
        }
    }
}