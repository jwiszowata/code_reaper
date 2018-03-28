public static String toString(GoodsType goodsType, int amount) {
    return amount + " " + ((goodsType == null) ? "(null)" : goodsType.getSuffix());
}