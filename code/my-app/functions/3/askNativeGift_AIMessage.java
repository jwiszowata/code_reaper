public static boolean askNativeGift(AIUnit aiUnit, Colony colony) {
    return aiUnit.getAIOwner().askServer().nativeGift(aiUnit.getUnit(), colony);
}