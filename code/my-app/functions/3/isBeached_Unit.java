public boolean isBeached(Tile tile) {
    return isNaval() && tile != null && tile.isLand() && !tile.hasSettlement();
}