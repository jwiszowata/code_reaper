public int priceGoods(List<AbstractGoods> goods) {
    Player player = getOwner();
    Market market = player.getMarket();
    int price = 0;
    for (AbstractGoods ag : transform(goods, AbstractGoods::isPositive)) {
        GoodsType goodsType = ag.getType();
        if (!player.canTrade(goodsType)) {
            price = -1;
            break;
        }
        price += market.getBidPrice(goodsType, ag.getAmount());
    }
    return price;
}