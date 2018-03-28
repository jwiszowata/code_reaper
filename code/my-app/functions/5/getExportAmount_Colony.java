public int getExportAmount(GoodsType goodsType, int turns) {
    final int present = ReturnPresent(goodsType, turns);
    final ExportData ed = getExportData(goodsType);
    return Math.max(0, present - ed.getExportLevel());
}