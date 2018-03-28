private int capAmount(int amount, int difficulty) {
    return Math.min(Math.max(amount * difficulty / 6, GOODS_DEMAND_MIN), GoodsContainer.CARGO_SIZE);
}