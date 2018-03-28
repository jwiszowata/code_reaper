public boolean unloadGoods(GoodsType type, int amount, Unit carrier) {
    return ask(carrier.getGame(), new UnloadGoodsMessage(type, amount, carrier));
}