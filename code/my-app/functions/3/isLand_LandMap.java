public boolean isLand(int x, int y) {
    return (isValid(x, y)) ? this.map[x][y] : false;
}