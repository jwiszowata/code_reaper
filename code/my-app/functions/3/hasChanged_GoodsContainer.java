public boolean hasChanged() {
    return any(getSpecification().getGoodsTypeList(), gt -> getOldGoodsCount(gt) != getGoodsCount(gt));
}