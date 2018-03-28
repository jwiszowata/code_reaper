private int getMilitaryGoodsPriceToBuy(GoodsType type, int amount) {
    final int full = GOODS_BASE_PRICE + getType().getTradeBonus();
    int required = getWantedGoodsAmount(type);
    if (required == 0)
        return 0;
    int valued = Math.max(0, required - getGoodsCount(type));
    int price = (valued > amount / 2) ? full * amount : valued * full + getNormalGoodsPriceToBuy(type, amount - valued);
    logger.finest("Military price(" + amount + " " + type + ")" + " valued=" + valued + " -> " + price);
    return price;
}