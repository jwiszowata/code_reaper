public TileImprovementPlan getBestPlan(Tile tile) {
    return (tipMap == null) ? null : tipMap.get(tile);
}