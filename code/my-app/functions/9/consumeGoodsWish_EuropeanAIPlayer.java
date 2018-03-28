public void consumeGoodsWish(AIGoods aig, GoodsWish gw) {
    final Goods goods = aig.getGoods();
    List<GoodsWish> gwL = goodsWishes.get(goods.getType());
    gwL.remove(gw);
    List<Wish> wl = transportDemand.get(gw.getDestination());
    if (wl != null)
        wl.remove(gw);
    gw.setTransportable(aig);
}