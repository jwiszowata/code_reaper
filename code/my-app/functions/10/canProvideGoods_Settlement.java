public boolean canProvideGoods(List<AbstractGoods> goods) {
    return all(goods, ag -> {
        int available = getGoodsCount(ag.getType());
        int breedingNumber = ag.getType().getBreedingNumber();
        if (breedingNumber != GoodsType.INFINITY) {
            available -= breedingNumber;
        }
        return available >= ag.getAmount();
    });
}