public int getImportAmount(GoodsType goodsType, int turns) {
    if (goodsType.limitIgnored())
        return GoodsContainer.HUGE_CARGO_SIZE;
    final int present = ReturnPresent(goodsType, turns);
    final ExportData ed = getExportData(goodsType);
    int capacity = ed.getEffectiveImportLevel(getWarehouseCapacity());
    return Math.max(0, capacity - present);
}