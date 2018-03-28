public boolean hasImprovement(TileImprovementType type) {
    TileImprovement improvement = getImprovement(type);
    return improvement != null && improvement.isComplete();
}