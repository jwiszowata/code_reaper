public int read() throws IOException {
    int c;
    do {
        c = this.in.read();
    } while (c == '\r');
    return c;
}