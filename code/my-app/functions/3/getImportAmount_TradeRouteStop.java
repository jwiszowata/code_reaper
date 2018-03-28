public int getImportAmount(GoodsType goodsType, int turns) {
    return (location instanceof TradeLocation) ? ((TradeLocation) location).getImportAmount(goodsType, turns) : 0;
}