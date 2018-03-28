public static boolean askWork(AIUnit aiUnit, WorkLocation workLocation) {
    return aiUnit.getAIOwner().askServer().work(aiUnit.getUnit(), workLocation);
}