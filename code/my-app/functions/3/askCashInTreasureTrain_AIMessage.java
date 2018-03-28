public static boolean askCashInTreasureTrain(AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().cashInTreasureTrain(aiUnit.getUnit());
}