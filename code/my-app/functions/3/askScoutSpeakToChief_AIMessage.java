public static boolean askScoutSpeakToChief(AIUnit aiUnit, IndianSettlement is) {
    return aiUnit.getAIOwner().askServer().scoutSpeakToChief(aiUnit.getUnit(), is);
}