public static boolean askEmbark(AIUnit aiUnit, Unit unit, Direction direction) {
    return aiUnit.getAIOwner().askServer().embark(unit, aiUnit.getUnit(), direction);
}