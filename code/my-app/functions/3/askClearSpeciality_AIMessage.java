public static boolean askClearSpeciality(AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().clearSpeciality(aiUnit.getUnit());
}