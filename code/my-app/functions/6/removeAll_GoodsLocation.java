public final void removeAll() {
    if (goodsContainer != null) {
        goodsContainer.removeAll();
        invalidateCache();
    }
}