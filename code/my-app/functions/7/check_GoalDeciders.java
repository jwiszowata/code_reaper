public boolean check(Unit u, PathNode pathNode) {
    Tile tile = pathNode.getTile();
    if (enemy.canSee(tile))
        return false;
    this.goal = pathNode;
    return true;
}