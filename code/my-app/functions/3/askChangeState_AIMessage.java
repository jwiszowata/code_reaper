public static boolean askChangeState(AIUnit aiUnit, UnitState state) {
    return aiUnit.getAIOwner().askServer().changeState(aiUnit.getUnit(), state);
}