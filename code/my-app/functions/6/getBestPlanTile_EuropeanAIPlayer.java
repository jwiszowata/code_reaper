public Tile getBestPlanTile(Colony colony) {
    final Comparator<TileImprovementPlan> valueComp = Comparator.comparingInt(TileImprovementPlan::getValue);
    final Function<Tile, TileImprovementPlan> tileMapper = t -> tipMap.get(t);
    TileImprovementPlan best = maximize(map(colony.getOwnedTiles(), tileMapper), isNotNull(), valueComp);
    return (best == null) ? null : best.getTarget();
}