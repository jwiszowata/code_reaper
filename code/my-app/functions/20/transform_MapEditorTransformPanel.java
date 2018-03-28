public void transform(Tile tile) {
    TileImprovementType riverType = tile.getSpecification().getTileImprovementType("model.improvement.river");
    if (riverType.isTileTypeAllowed(tile.getType())) {
        if (!tile.hasRiver()) {
            StringBuilder sb = new StringBuilder(64);
            for (Direction direction : Direction.longSides) {
                Tile t = tile.getNeighbourOrNull(direction);
                TileImprovement otherRiver = (t == null) ? null : t.getRiver();
                if (t == null || (t.isLand() && otherRiver == null)) {
                    sb.append('0');
                } else {
                    sb.append(magnitude);
                }
            }
            tile.addRiver(magnitude, sb.toString());
        } else {
            tile.removeRiver();
        }
    }
}