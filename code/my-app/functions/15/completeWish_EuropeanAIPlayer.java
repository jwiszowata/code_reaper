public void completeWish(Wish w) {
    if (w instanceof WorkerWish) {
        WorkerWish ww = (WorkerWish) w;
        List<WorkerWish> wl = workerWishes.get(ww.getUnitType());
        if (wl != null)
            wl.remove(ww);
    } else if (w instanceof GoodsWish) {
        GoodsWish gw = (GoodsWish) w;
        List<GoodsWish> gl = goodsWishes.get(gw.getGoodsType());
        if (gl != null)
            gl.remove(gw);
    } else {
        throw new IllegalStateException("Bogus wish: " + w);
    }
}