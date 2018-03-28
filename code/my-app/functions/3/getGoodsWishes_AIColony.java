public List<GoodsWish> getGoodsWishes() {
    return transform(wishes, w -> w instanceof GoodsWish, w -> (GoodsWish) w);
}