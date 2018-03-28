public static void moveGoods(GoodsLocation src, GoodsType goodsType, int amount, GoodsLocation dst) {
    if (src != null)
        src.removeGoods(goodsType, amount);
    if (dst != null)
        dst.addGoods(goodsType, amount);
}