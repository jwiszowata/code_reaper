public void reset() throws IOException {
    if (this.markStart < 0) {
        throw new IOException("reset of unmarked stream");
    }
    this.bStart = this.markStart;
    this.bSize = this.markSize;
}