public static String makeKey(Location where, GoodsType what) {
    return what.getId() + "-" + where.getId();
}