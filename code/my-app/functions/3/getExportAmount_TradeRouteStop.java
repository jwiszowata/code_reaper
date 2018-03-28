public int getExportAmount(GoodsType goodsType, int turns) {
    return (location instanceof TradeLocation) ? ((TradeLocation) location).getExportAmount(goodsType, turns) : 0;
}