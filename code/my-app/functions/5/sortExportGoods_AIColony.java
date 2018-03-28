private void sortExportGoods() {
    synchronized (exportGoods) {
        exportGoods.sort(ValuedAIObject.descendingValueComparator);
    }
}