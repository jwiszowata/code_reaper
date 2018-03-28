public void disposeResources() {
    synchronized (this.units) {
        this.units.clear();
    }
    super.disposeResources();
}