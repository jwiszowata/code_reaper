public int getMoveCost(Tile from, Tile target, int ml) {
    int cost = target.getType().getBasicMoveCost();
    if (target.isLand() && !isNaval()) {
        TileItemContainer container = target.getTileItemContainer();
        if (container != null) {
            cost = container.getMoveCost(from, target, cost);
        }
    }
    if (isBeached(from)) {
        cost = ml;
    } else if (cost > ml) {
        if ((ml + 2 >= getInitialMovesLeft() || cost <= ml + 2 || target.hasSettlement()) && ml != 0) {
            cost = ml;
        }
    }
    return cost;
}