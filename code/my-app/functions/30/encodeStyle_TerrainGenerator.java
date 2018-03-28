public static void encodeStyle(Tile tile) {
    EnumMap<Direction, Boolean> connections = new EnumMap<>(Direction.class);
    for (Direction d : Direction.corners) {
        Tile t = tile.getNeighbourOrNull(d);
        connections.put(d, t != null && t.isLand());
    }
    for (Direction d : Direction.longSides) {
        Tile t = tile.getNeighbourOrNull(d);
        if (t != null && t.isLand()) {
            connections.put(d, Boolean.TRUE);
            connections.put(d.getNextDirection(), Boolean.FALSE);
            connections.put(d.getPreviousDirection(), Boolean.FALSE);
        } else {
            connections.put(d, Boolean.FALSE);
        }
    }
    int result = 0;
    int index = 0;
    for (Direction d : Direction.corners) {
        if (connections.get(d))
            result += (int) Math.pow(2, index);
        index++;
    }
    for (Direction d : Direction.longSides) {
        if (connections.get(d))
            result += (int) Math.pow(2, index);
        index++;
    }
    tile.setStyle(result);
}