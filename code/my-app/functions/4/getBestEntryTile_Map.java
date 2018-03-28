public Tile getBestEntryTile(Unit unit, Tile tile, Unit carrier, CostDecider costDecider) {
    PathNode path = getBestEntryPath(unit, tile, carrier, costDecider);
    return (path == null) ? null : path.getLastNode().getTile();
}