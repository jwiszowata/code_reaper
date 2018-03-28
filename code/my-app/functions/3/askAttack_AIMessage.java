public static boolean askAttack(AIUnit aiUnit, Direction direction) {
    return aiUnit.getAIOwner().askServer().attack(aiUnit.getUnit(), direction);
}