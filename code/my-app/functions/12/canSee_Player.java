public boolean canSee(Tile tile) {
    if (tile == null)
        return false;
    do {
        synchronized (canSeeLock) {
            if (canSeeValid) {
                return canSeeTiles[tile.getX()][tile.getY()];
            }
        }
    } while (resetCanSeeTiles());
    return false;
}