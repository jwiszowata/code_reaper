public int getLibertyProductionNextTurn() {
    final Specification spec = getSpecification();
    final List<GoodsType> goodsTypes = spec.getLibertyGoodsTypeList();
    int nextTurn = sum(getColonies(), c -> sum(goodsTypes, gt -> c.getTotalProductionOf(gt)));
    return (int) applyModifiers((float) nextTurn, getGame().getTurn(), Modifier.LIBERTY);
}