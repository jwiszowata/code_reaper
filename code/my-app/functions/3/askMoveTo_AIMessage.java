public static boolean askMoveTo(AIUnit aiUnit, Location destination) {
    return aiUnit.getAIOwner().askServer().moveTo(aiUnit.getUnit(), destination);
}