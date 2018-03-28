public static boolean askChangeWorkImprovementType(AIUnit aiUnit, TileImprovementType type) {
    return aiUnit.getAIOwner().askServer().changeWorkImprovementType(aiUnit.getUnit(), type);
}