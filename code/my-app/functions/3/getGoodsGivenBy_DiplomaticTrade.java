public List<Goods> getGoodsGivenBy(Player player) {
    return transform(this.items, ti -> ti instanceof GoodsTradeItem && ti.getSource() == player, TradeItem::getGoods);
}