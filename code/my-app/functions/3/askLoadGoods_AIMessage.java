public static boolean askLoadGoods(Location loc, GoodsType type, int amount, AIUnit aiUnit) {
    return aiUnit.getAIOwner().askServer().loadGoods(loc, type, amount, aiUnit.getUnit());
}