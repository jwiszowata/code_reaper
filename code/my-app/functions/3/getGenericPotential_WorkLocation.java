public int getGenericPotential(GoodsType goodsType) {
    return getPotentialProduction(goodsType, getSpecification().getDefaultUnitType(getOwner()));
}