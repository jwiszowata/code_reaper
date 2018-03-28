public List<AIGoods> getExportGoods() {
    synchronized (exportGoods) {
        return new ArrayList<>(exportGoods);
    }
}