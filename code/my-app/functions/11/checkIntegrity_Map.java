public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    final int hgt = getHeight(), wid = getWidth();
    for (int y = 0; y < hgt; y++) {
        for (int x = 0; x < wid; x++) {
            Tile t = this.tiles[x][y];
            result = Math.min(result, t.checkIntegrity(fix));
        }
    }
    return result;
}