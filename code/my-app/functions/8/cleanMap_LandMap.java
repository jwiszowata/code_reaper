private void cleanMap() {
    for (int y = 0; y < this.height; y++) {
        for (int x = 0; x < this.width; x++) {
            if (!hasAdjacentLand(x, y))
                this.map[x][y] = false;
        }
    }
}