public static void moveGoods(GoodsContainer src, GoodsType goodsType, int amount, GoodsContainer dst) {
    if (src != null) {
        src.saveState();
        src.removeGoods(goodsType, amount);
    }
    if (dst != null) {
        dst.saveState();
        dst.addGoods(goodsType, amount);
    }
}