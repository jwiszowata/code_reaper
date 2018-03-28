public static boolean askDisband(AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().disbandUnit(aiUnit.getUnit());
}