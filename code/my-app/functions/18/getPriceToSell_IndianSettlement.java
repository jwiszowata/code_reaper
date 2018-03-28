public int getPriceToSell(GoodsType type, int amount) {
    if (amount > GoodsContainer.CARGO_SIZE) {
        throw new IllegalArgumentException("Amount > " + GoodsContainer.CARGO_SIZE);
    }
    final int full = GOODS_BASE_PRICE + getType().getTradeBonus();
    int price = amount + Math.max(0, 11 * getPriceToBuy(type, amount) / 10);
    if (type.getMilitary()) {
        price = Math.max(price, amount * full * 2);
    } else if (type.isTradeGoods()) {
        price = Math.max(price, 150 * amount * full / 100);
    } else {
        GoodsType raw = type.getInputType();
        if (raw != null && getMaximumProduction(raw) == 0) {
            price += amount;
        }
    }
    return price;
}