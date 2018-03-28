public int getNetProductionOf(GoodsType type) {
    update();
    return netProduction.getCount(type);
}