private void setSocket(Socket socket) {
    synchronized (this.inputLock) {
        this.socket = socket;
    }
}