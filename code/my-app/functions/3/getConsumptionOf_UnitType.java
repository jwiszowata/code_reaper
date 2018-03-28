public int getConsumptionOf(GoodsType goodsType) {
    return (consumption == null) ? 0 : consumption.getCount(goodsType);
}