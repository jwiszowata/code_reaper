private static TileImprovementPlan getBestPlan(AIUnit aiUnit, Tile tile) {
    return ((EuropeanAIPlayer) aiUnit.getAIOwner()).getBestPlan(tile);
}