private void closeInputStream() {
    synchronized (this.inputLock) {
        if (this.in == null)
            return;
        try {
            this.in.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Error closing input", ioe);
        } finally {
            this.in = null;
        }
    }
}