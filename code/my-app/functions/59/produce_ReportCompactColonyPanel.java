private void produce(GoodsType goodsType) {
    final ExportData exportData = colony.getExportData(goodsType);
    final int adjustment = colony.getWarehouseCapacity() / GoodsContainer.CARGO_SIZE;
    final int low = exportData.getLowLevel() * adjustment;
    final int high = exportData.getHighLevel() * adjustment;
    final int amount = colony.getGoodsCount(goodsType);
    int p = colony.getAdjustedNetProductionOf(goodsType);
    ProductionStatus status;
    AbstractGoods deficit;
    int extra = 0;
    if (p < 0) {
        status = (amount < low) ? ProductionStatus.FAIL : ProductionStatus.BAD;
        extra = -amount / p + 1;
    } else if (p == 0 && !colony.isProducing(goodsType)) {
        status = ProductionStatus.NONE;
    } else if (p == 0) {
        status = ProductionStatus.ZERO;
        extra = 0;
        deficit = null;
        for (WorkLocation wl : colony.getWorkLocationsForProducing(goodsType)) {
            ProductionInfo pi = colony.getProductionInfo(wl);
            if (pi == null)
                continue;
            deficit = find(pi.getConsumptionDeficit(), AbstractGoods.matches(goodsType));
            if (deficit != null) {
                status = ProductionStatus.CONSUMPTION;
                extra = deficit.getAmount();
                break;
            }
        }
    } else if (exportData.getExported()) {
        status = ProductionStatus.EXPORT;
        extra = exportData.getExportLevel();
    } else if (goodsType.limitIgnored()) {
        status = ProductionStatus.GOOD;
    } else if (amount + p > colony.getWarehouseCapacity()) {
        status = ProductionStatus.OVERFLOW;
        extra = amount + p - colony.getWarehouseCapacity();
    } else if (amount >= high) {
        status = ProductionStatus.EXCESS;
        extra = (colony.getWarehouseCapacity() - amount) / p;
    } else {
        status = ProductionStatus.GOOD;
        extra = 0;
        deficit = null;
        for (WorkLocation wl : colony.getWorkLocationsForProducing(goodsType)) {
            ProductionInfo pi = colony.getProductionInfo(wl);
            if (pi == null)
                continue;
            deficit = find(pi.getProductionDeficit(), AbstractGoods.matches(goodsType));
            if (deficit != null) {
                status = ProductionStatus.PRODUCTION;
                extra = deficit.getAmount();
                break;
            }
        }
    }
    this.production.put(goodsType, new GoodsProduction(p, status, extra));
}