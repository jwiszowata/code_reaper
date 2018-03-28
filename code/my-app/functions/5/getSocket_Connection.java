public Socket getSocket() {
    synchronized (this.inputLock) {
        return this.socket;
    }
}