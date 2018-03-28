public int getGoodsCount(GoodsType goodsType) {
    return (location instanceof TradeLocation) ? ((TradeLocation) location).getGoodsCount(goodsType) : 0;
}