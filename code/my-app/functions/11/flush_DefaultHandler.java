public void flush() {
    synchronized (this.writerLock) {
        if (this.writer != null) {
            try {
                this.writer.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        }
    }
}