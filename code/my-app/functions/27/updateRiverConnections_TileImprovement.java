public String updateRiverConnections(String conns) {
    if (!isRiver())
        return null;
    final Tile tile = getTile();
    int i = 0;
    for (Direction d : Direction.longSides) {
        Direction dReverse = d.getReverseDirection();
        Tile t = tile.getNeighbourOrNull(d);
        TileImprovement river = (t == null) ? null : t.getRiver();
        String c = (conns == null) ? "0" : conns.substring(i, i + 1);
        if ("0".equals(c)) {
            if (river != null) {
                river.setConnected(dReverse, false);
            }
            setConnected(d, false);
        } else {
            if (river != null) {
                river.setConnected(dReverse, true);
                setConnected(d, true);
            } else if (t != null && t.getType().isWater()) {
                setConnected(d, true);
            }
        }
        i++;
    }
    return (style == null) ? null : style.getString();
}