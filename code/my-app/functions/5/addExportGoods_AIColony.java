private void addExportGoods(AIGoods aiGoods) {
    synchronized (exportGoods) {
        exportGoods.add(aiGoods);
    }
}