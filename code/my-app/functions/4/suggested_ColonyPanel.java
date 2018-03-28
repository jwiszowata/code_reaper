public int suggested(GoodsType type) {
    Colony colony = getColony();
    return colony.getWarehouseCapacity() - colony.getGoodsCount(type);
}