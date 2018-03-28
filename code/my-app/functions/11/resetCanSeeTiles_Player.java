private boolean resetCanSeeTiles() {
    Map map = getGame().getMap();
    if (map == null)
        return false;
    boolean[][] cST = makeCanSeeTiles(map);
    synchronized (canSeeLock) {
        canSeeTiles = cST;
        canSeeValid = true;
    }
    return true;
}