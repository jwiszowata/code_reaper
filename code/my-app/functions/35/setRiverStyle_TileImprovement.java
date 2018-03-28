public void setRiverStyle(String conns) {
    if (!isRiver())
        return;
    final Tile tile = getTile();
    int i = 0;
    int[] counts = { 0, 0 };
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
            int mag = Integer.parseInt(c);
            if (river != null) {
                river.setConnected(dReverse, true);
                setConnected(d, true, c);
                counts[mag - 1]++;
            } else if (t != null) {
                if (!t.getType().isWater()) {
                    t.addRiver(mag, "0000");
                    t.getRiver().setConnected(dReverse, true);
                }
                setConnected(d, true, c);
                counts[mag - 1]++;
            }
        }
        i++;
    }
    magnitude = counts[1] >= counts[0] ? 2 : 1;
}