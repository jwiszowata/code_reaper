public int getPriceForBuilding(BuildableType type) {
    return priceGoodsForBuilding(getRequiredGoods(type));
}