private void clearContainers() {
    synchronized (this.storedGoods) {
        this.storedGoods.clear();
        synchronized (this.oldStoredGoods) {
            this.oldStoredGoods.clear();
        }
    }
}