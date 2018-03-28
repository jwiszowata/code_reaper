public synchronized void invalidate(GoodsType goodsType) {
    if (goodsUsed.contains(goodsType)) {
        upToDate = false;
    }
}