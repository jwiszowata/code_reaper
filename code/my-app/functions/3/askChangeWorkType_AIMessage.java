public static boolean askChangeWorkType(AIUnit aiUnit, GoodsType type) {
    return aiUnit.getAIOwner().askServer().changeWorkType(aiUnit.getUnit(), type);
}