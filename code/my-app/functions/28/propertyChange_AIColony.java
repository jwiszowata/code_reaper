public void propertyChange(PropertyChangeEvent event) {
    logger.finest("Property change REARRANGE_WORKERS fired.");
    requestRearrange();
    if (event != null && event.getOldValue() instanceof GoodsType) {
        GoodsType goodsType = (GoodsType) event.getOldValue();
        int left = colony.getGoodsCount(goodsType);
        for (AIGoods aig : getExportGoods()) {
            boolean remove = false;
            if (aig.isDisposed()) {
                remove = true;
            } else if (aig.getGoods() == null) {
                aig.changeTransport(null);
                remove = true;
            } else if (aig.getGoodsType() == goodsType) {
                if (left > 0) {
                    aig.getGoods().setAmount(left);
                } else {
                    aig.changeTransport(null);
                    remove = true;
                }
            }
            if (remove) {
                removeExportGoods(aig);
                break;
            }
        }
    }
}