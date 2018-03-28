private void closeOutputStream() {
    synchronized (this.outputLock) {
        if (this.out == null)
            return;
        try {
            this.out.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Error closing output", ioe);
        } finally {
            this.out = null;
        }
    }
}