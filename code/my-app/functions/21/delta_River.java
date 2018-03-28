private void delta(Tile tile, Direction direction, RiverSection section, Direction d) {
    Tile t = tile.getNeighbourOrNull(d);
    if (!t.isLand()) {
        List<RiverSection> deltaSections = new ArrayList<>();
        section.setBranch(d, TileImprovement.SMALL_RIVER);
        deltaSections.add(new RiverSection(tile, d.getReverseDirection()));
        drawToMap(deltaSections);
    } else if (riverType.isTileTypeAllowed(t.getType())) {
        Tile t2 = t.getNeighbourOrNull(direction);
        if (!t2.isLand() && randomInt(logger, "Delta", random, 2) == 0) {
            List<RiverSection> deltaSections = new ArrayList<>();
            section.setBranch(d, TileImprovement.SMALL_RIVER);
            RiverSection rs = new RiverSection(t, direction);
            rs.setBranch(d.getReverseDirection(), TileImprovement.SMALL_RIVER);
            deltaSections.add(rs);
            rs = new RiverSection(t2, direction.getReverseDirection());
            deltaSections.add(rs);
            drawToMap(deltaSections);
        }
    }
}