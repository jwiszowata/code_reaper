public boolean isOnRiver() {
    final TileType greatRiver = getSpecification().getTileType("model.tile.greatRiver");
    final TileType ocean = getSpecification().getTileType("model.tile.ocean");
    boolean ret = getType() == greatRiver;
    for (Tile t : getSurroundingTiles(1)) {
        if (t.getType() == ocean)
            return false;
        ret |= t.getType() == greatRiver;
    }
    return ret;
}