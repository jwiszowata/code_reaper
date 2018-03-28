public void clearModelMessages() {
    synchronized (this.modelMessages) {
        this.modelMessages.clear();
    }
}