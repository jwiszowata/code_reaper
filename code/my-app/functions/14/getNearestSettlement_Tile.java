public Settlement getNearestSettlement(Player owner, int radius, boolean same) {
    if (radius <= 0)
        radius = INFINITY;
    Map map = getGame().getMap();
    for (Tile t : map.getCircleTiles(this, true, radius)) {
        if (t == this || (same && !isConnectedTo(t)))
            continue;
        Settlement settlement = t.getSettlement();
        if (settlement != null && (owner == null || owner.owns(settlement))) {
            return settlement;
        }
    }
    return null;
}