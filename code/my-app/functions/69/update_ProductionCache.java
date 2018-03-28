private synchronized void update() {
    if (upToDate)
        return;
    final Specification spec = colony.getSpecification();
    final GoodsType bells = spec.getGoodsType("model.goods.bells");
    productionAndConsumption.clear();
    netProduction.clear();
    goodsUsed.clear();
    ProductionMap production = new ProductionMap();
    for (ColonyTile colonyTile : colony.getColonyTiles()) {
        ProductionInfo info = colonyTile.getBasicProductionInfo();
        production.add(info.getProduction());
        productionAndConsumption.put(colonyTile, info);
        for (AbstractGoods goods : info.getProduction()) {
            goodsUsed.add(goods.getType());
            netProduction.incrementCount(goods.getType().getStoredAs(), goods.getAmount());
        }
    }
    int unitsThatUseNoBells = spec.getInteger(GameOptions.UNITS_THAT_USE_NO_BELLS);
    int amount = Math.min(unitsThatUseNoBells, colony.getUnitCount());
    ProductionInfo bellsInfo = new ProductionInfo();
    bellsInfo.addProduction(new AbstractGoods(bells, amount));
    productionAndConsumption.put(this, bellsInfo);
    netProduction.incrementCount(bells, amount);
    List<AbstractGoods> goods = new ArrayList<>();
    for (Consumer consumer : colony.getConsumers()) {
        List<Modifier> modifiers = toList(consumer.getModifiers(Modifier.CONSUME_ONLY_SURPLUS_PRODUCTION));
        goods.clear();
        for (AbstractGoods g : consumer.getConsumedGoods()) {
            goodsUsed.add(g.getType());
            AbstractGoods surplus = new AbstractGoods(production.get(g.getType()));
            if (modifiers.isEmpty()) {
                surplus.setAmount(surplus.getAmount() + getGoodsCount(g.getType()));
            } else {
                surplus.setAmount((int) FeatureContainer.applyModifiers(surplus.getAmount(), null, modifiers));
            }
            goods.add(surplus);
        }
        ProductionInfo info = null;
        if (consumer instanceof Building) {
            Building building = (Building) consumer;
            final Function<AbstractGoods, AbstractGoods> mapper = ag -> {
                GoodsType outputType = ag.getType();
                AbstractGoods newOutput = new AbstractGoods(production.get(outputType));
                newOutput.setAmount(newOutput.getAmount() + getGoodsCount(outputType));
                return newOutput;
            };
            List<AbstractGoods> outputs = transform(building.getOutputs(), alwaysTrue(), mapper);
            goodsUsed.addAll(transform(outputs, alwaysTrue(), AbstractGoods::getType));
            info = building.getAdjustedProductionInfo(goods, outputs);
        } else if (consumer instanceof Unit) {
            info = ((Unit) consumer).getProductionInfo(goods);
        } else if (consumer instanceof BuildQueue) {
            info = ((BuildQueue<?>) consumer).getProductionInfo(goods);
        }
        if (info != null) {
            production.add(info.getProduction());
            production.remove(info.getConsumption());
            for (AbstractGoods g : info.getProduction()) {
                netProduction.incrementCount(g.getType().getStoredAs(), g.getAmount());
            }
            for (AbstractGoods g : info.getConsumption()) {
                netProduction.incrementCount(g.getType().getStoredAs(), -g.getAmount());
            }
            productionAndConsumption.put(consumer, info);
        }
    }
    upToDate = true;
}