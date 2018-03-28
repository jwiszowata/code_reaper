public static boolean askLoot(AIUnit aiUnit, String defenderId, List<Goods> goods) {
    return aiUnit.getAIOwner().askServer().loot(aiUnit.getUnit(), defenderId, goods);
}