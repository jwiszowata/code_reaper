public GoodsWish getBestGoodsWish(AIUnit aiUnit, GoodsType goodsType) {
    final Unit carrier = aiUnit.getUnit();
    final ToDoubleFunction<GoodsWish> wishValue = cacheDouble(gw -> {
        int turns = carrier.getTurnsToReach(carrier.getLocation(), gw.getDestination());
        return (turns >= Unit.MANY_TURNS) ? -1.0 : (double) gw.getValue() / turns;
    });
    final Comparator<GoodsWish> comp = Comparator.comparingDouble(wishValue);
    List<GoodsWish> wishes = goodsWishes.get(goodsType);
    return (wishes == null) ? null : maximize(wishes, gw -> wishValue.applyAsDouble(gw) > 0.0, comp);
}