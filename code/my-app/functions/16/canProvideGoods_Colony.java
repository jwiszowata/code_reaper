public boolean canProvideGoods(List<AbstractGoods> requiredGoods) {
    BuildableType buildable = getCurrentlyBuilding();
    for (AbstractGoods goods : requiredGoods) {
        int available = getGoodsCount(goods.getType());
        int breedingNumber = goods.getType().getBreedingNumber();
        if (breedingNumber != GoodsType.INFINITY) {
            available -= breedingNumber;
        }
        if (buildable != null) {
            available -= AbstractGoods.getCount(goods.getType(), buildable.getRequiredGoodsList());
        }
        if (available < goods.getAmount())
            return false;
    }
    return true;
}