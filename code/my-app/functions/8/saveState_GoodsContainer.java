public void saveState() {
    synchronized (this.storedGoods) {
        synchronized (this.oldStoredGoods) {
            this.oldStoredGoods.clear();
            this.oldStoredGoods.putAll(this.storedGoods);
        }
    }
}