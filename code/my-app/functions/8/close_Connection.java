public void close() {
    if (this.receivingThread != null)
        this.receivingThread.askToStop();
    closeOutputStream();
    closeInputStream();
    closeSocket();
    logger.fine("Connection closed for " + this.name);
}