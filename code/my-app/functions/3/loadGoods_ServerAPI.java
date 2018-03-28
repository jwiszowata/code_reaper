public boolean loadGoods(Location loc, GoodsType type, int amount, Unit carrier) {
    return ask(carrier.getGame(), new LoadGoodsMessage(loc, type, amount, carrier));
}