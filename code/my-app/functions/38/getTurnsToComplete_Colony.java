public int getTurnsToComplete(BuildableType buildable, AbstractGoods needed) {
    final List<AbstractGoods> required = buildable.getRequiredGoodsList();
    int turns = 0, satisfied = 0, failing = 0, underway = 0;
    ProductionInfo info = productionCache.getProductionInfo(buildQueue);
    for (AbstractGoods ag : required) {
        final GoodsType type = ag.getType();
        final int amountNeeded = ag.getAmount();
        final int amountAvailable = getGoodsCount(type);
        if (amountAvailable >= amountNeeded) {
            satisfied++;
            continue;
        }
        int production = productionCache.getNetProductionOf(type);
        if (info != null) {
            AbstractGoods consumption = find(info.getConsumption(), AbstractGoods.matches(type));
            if (consumption != null) {
                production += consumption.getAmount();
            }
        }
        if (production <= 0) {
            failing++;
            if (needed != null) {
                needed.setType(type);
                needed.setAmount(amountNeeded - amountAvailable);
            }
            continue;
        }
        underway++;
        int amountRemaining = amountNeeded - amountAvailable;
        int eta = amountRemaining / production;
        if (amountRemaining % production != 0)
            eta++;
        turns = Math.max(turns, eta);
    }
    return // Will finish
    (satisfied + underway == required.size()) ? turns : // Not even trying
    (failing == required.size()) ? UNDEFINED : -(turns + 1);
}