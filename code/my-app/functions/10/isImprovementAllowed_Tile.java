public boolean isImprovementAllowed(TileImprovement tip) {
    final TileImprovementType type = tip.getType();
    if (!isImprovementTypeAllowed(type))
        return false;
    TileImprovementType req = type.getRequiredImprovementType();
    if (req != null && getTileImprovement(req) == null)
        return false;
    TileImprovement ti = getTileImprovement(type);
    return ti == null || !ti.isComplete();
}