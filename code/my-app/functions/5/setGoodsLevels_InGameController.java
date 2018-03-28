public boolean setGoodsLevels(Colony colony, GoodsType goodsType) {
    if (colony == null || goodsType == null)
        return false;
    return askServer().setGoodsLevels(colony, colony.getExportData(goodsType));
}