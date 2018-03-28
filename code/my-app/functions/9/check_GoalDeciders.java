public boolean check(Unit u, PathNode pathNode) {
    Tile tile = pathNode.getTile();
    if (tile.getHighSeasCount() < score && tile.isRiverCorner()) {
        score = tile.getHighSeasCount();
        goal = pathNode;
        return true;
    }
    return false;
}