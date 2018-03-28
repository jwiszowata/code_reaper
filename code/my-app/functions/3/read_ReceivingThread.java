public int read() throws IOException {
    return (read(bb, 0, 1) == 1) ? bb[0] : EOS_RESULT;
}