public void close() {
    synchronized (this.writerLock) {
        if (this.writer != null) {
            try {
                this.writer.close();
                this.writer = null;
            } catch (IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        }
    }
}