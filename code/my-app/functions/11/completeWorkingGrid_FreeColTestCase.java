private void completeWorkingGrid() {
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            if (tiles[x][y] != null) {
                continue;
            }
            tiles[x][y] = baseTile;
        }
    }
    initiated = true;
}