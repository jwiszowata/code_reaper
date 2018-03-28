public boolean canProduce(GoodsType goodsType, UnitType unitType) {
    synchronized (tileItems) {
        return any(tileItems, ti -> ti.canProduce(goodsType, unitType));
    }
}