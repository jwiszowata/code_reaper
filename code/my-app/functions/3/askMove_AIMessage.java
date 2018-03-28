public static boolean askMove(AIUnit aiUnit, Direction direction) {
    return aiUnit.getAIOwner().askServer().move(aiUnit.getUnit(), direction);
}