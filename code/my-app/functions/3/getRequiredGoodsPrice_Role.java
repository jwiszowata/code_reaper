public int getRequiredGoodsPrice(Market market) {
    return sum(getRequiredGoods(), ag -> market.getBidPrice(ag.getType(), ag.getAmount() * getMaximumCount()));
}