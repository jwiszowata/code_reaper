public boolean isOnCarrier() {
    Goods goods = getGoods();
    return goods != null && goods.getLocation() instanceof Unit;
}