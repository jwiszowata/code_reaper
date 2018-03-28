public boolean isNextToWater(Tile tile) {
    return any(Direction.longSides, d -> {
        Tile t = tile.getNeighbourOrNull(d);
        return t != null && (!t.isLand() || t.hasRiver());
    });
}