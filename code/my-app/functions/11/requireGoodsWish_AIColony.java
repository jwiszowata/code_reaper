public void requireGoodsWish(GoodsType type, int amount, int value, LogBuilder lb) {
    GoodsWish gw = (GoodsWish) find(wishes, w -> w instanceof GoodsWish && ((GoodsWish) w).getGoodsType() == type);
    if (gw != null) {
        gw.update(type, amount, gw.getValue() + 1);
        lb.add(", update ", gw);
    } else {
        gw = new GoodsWish(getAIMain(), colony, value, amount, type);
        wishes.add(gw);
        lb.add(", add ", gw);
    }
}