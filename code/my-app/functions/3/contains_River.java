public boolean contains(Tile tile) {
    return any(getSections(), rs -> rs.getTile() == tile);
}