public void restoreState() {
    synchronized (this.storedGoods) {
        synchronized (this.oldStoredGoods) {
            this.storedGoods.clear();
            this.storedGoods.putAll(this.oldStoredGoods);
        }
    }
}