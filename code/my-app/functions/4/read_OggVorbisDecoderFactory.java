public int read() throws IOException {
    byte[] b = new byte[1];
    return (read(b) > 0) ? b[0] : -1;
}