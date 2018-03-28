private void clearExportGoods() {
    synchronized (exportGoods) {
        exportGoods.clear();
    }
}