public static boolean askUnloadGoods(GoodsType type, int amount, AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().unloadGoods(type, amount, aiUnit.getUnit());
}