public static boolean askPutOutsideColony(AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().putOutsideColony(aiUnit.getUnit());
}