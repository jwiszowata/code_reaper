private void clearHistory() {
    synchronized (this.history) {
        this.history.clear();
    }
}