public boolean canBreed(GoodsType goodsType) {
    int breedingNumber = goodsType.getBreedingNumber();
    return (breedingNumber < GoodsType.INFINITY && breedingNumber <= getGoodsCount(goodsType));
}