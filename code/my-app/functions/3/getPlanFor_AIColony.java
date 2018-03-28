private TileImprovementPlan getPlanFor(Tile tile, List<TileImprovementPlan> plans) {
    return find(plans, tip -> tip.getTarget() == tile);
}