public void removeAll() {
    synchronized (this.storedGoods) {
        this.storedGoods.clear();
    }
}