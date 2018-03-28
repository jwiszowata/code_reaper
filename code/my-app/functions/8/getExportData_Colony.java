public ExportData getExportData(final GoodsType goodsType) {
    ExportData result = exportData.get(goodsType.getId());
    if (result == null) {
        result = new ExportData(goodsType, getWarehouseCapacity());
        setExportData(result);
    }
    return result;
}