public static boolean askDisembark(AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().disembark(aiUnit.getUnit());
}