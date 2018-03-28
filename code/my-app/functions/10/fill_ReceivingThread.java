private boolean fill() throws IOException {
    if (this.bSize != 0)
        throw new IllegalStateException("Not empty.");
    int r = super.read(buffer, 0, buffer.length);
    if (r <= 0)
        return false;
    this.bStart = 0;
    this.bSize = r;
    return true;
}