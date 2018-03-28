public void removeExportGoods(AIGoods ag) {
    synchronized (exportGoods) {
        while (exportGoods.remove(ag)) {
        }
    }
}