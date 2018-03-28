public static boolean askEstablishMission(AIUnit aiUnit, Direction direction, boolean denounce) {
    return aiUnit.getAIOwner().askServer().missionary(aiUnit.getUnit(), direction, denounce);
}