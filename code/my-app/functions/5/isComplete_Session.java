public boolean isComplete() {
    synchronized (this) {
        return this.completed;
    }
}