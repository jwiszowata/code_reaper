public String updateRoadConnections(boolean connect) {
    if (!isRoad() || !isComplete())
        return null;
    final Tile tile = getTile();
    for (Direction d : Direction.values()) {
        Tile t = tile.getNeighbourOrNull(d);
        TileImprovement road = (t == null) ? null : t.getRoad();
        if (road != null && road.isComplete()) {
            road.setConnected(d.getReverseDirection(), connect);
            setConnected(d, connect);
        } else {
            setConnected(d, false);
        }
    }
    return (style == null) ? null : style.getString();
}