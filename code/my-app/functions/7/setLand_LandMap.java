private boolean setLand(int x, int y) {
    if (isLand(x, y))
        return false;
    this.map[x][y] = true;
    this.numberOfLandTiles++;
    return true;
}