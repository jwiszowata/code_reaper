public Stream<Modifier> getProductionModifiers(GoodsType goodsType, UnitType unitType) {
    synchronized (tileItems) {
        return flatten(tileItems, ti -> ti.getProductionModifiers(goodsType, unitType));
    }
}