public int getFoodProduction() {
    return sum(getSpecification().getFoodGoodsTypeList(), ft -> getTotalProductionOf(ft));
}