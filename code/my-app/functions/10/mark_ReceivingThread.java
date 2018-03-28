public void mark(int readLimit) {
    if (this.bSize == 0) {
        try {
            fill();
        } catch (IOException ioe) {
        }
    }
    this.markStart = this.bStart;
    this.markSize = this.bSize;
}