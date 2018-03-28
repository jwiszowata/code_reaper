public synchronized boolean disconnect() {
    if (this.connection != null) {
        this.connection.disconnect();
        this.connection = null;
    }
    return true;
}