public void removeAbove(final int newAmount) {
    synchronized (this.storedGoods) {
        if (newAmount <= 0) {
            this.storedGoods.clear();
            return;
        }
        final Predicate<Entry<GoodsType, Integer>> hiPred = e -> {
            final GoodsType gt = e.getKey();
            return gt.isStorable() && !gt.limitIgnored() && e.getValue() > newAmount;
        };
        forEachMapEntry(this.storedGoods, hiPred, e -> this.storedGoods.put(e.getKey(), newAmount));
    }
}