public static boolean canProduce(final GoodsType goodsType, Collection<ProductionType> types) {
    return any(flatten(types, ProductionType::getOutputs), ag -> goodsType == ag.getType() && ag.getAmount() > 0);
}