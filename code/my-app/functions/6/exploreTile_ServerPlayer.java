public boolean exploreTile(Tile tile) {
    boolean ret = !hasExplored(tile);
    if (ret)
        tile.setExplored(this, true);
    return ret;
}