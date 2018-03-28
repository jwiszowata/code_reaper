public TileImprovement getTileImprovement(TileImprovementType type) {
    return (tileItemContainer == null) ? null : tileItemContainer.getImprovement(type);
}