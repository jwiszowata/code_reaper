private void setExportGoods(List<AIGoods> aiGoods) {
    clearExportGoods();
    synchronized (exportGoods) {
        exportGoods.addAll(aiGoods);
    }
    sortExportGoods();
}