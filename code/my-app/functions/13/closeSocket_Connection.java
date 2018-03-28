private void closeSocket() {
    synchronized (this.inputLock) {
        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException ioe) {
                logger.log(Level.WARNING, "Error closing socket", ioe);
            } finally {
                this.socket = null;
            }
        }
    }
}