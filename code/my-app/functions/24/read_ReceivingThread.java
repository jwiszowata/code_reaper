public int read(byte[] b, int off, int len) throws IOException {
    if (this.wait)
        return EOS_RESULT;
    int n = 0;
    for (; n < len; n++) {
        if (this.bSize == 0) {
            if (fill()) {
                unmark();
            } else {
                this.wait = true;
                break;
            }
        }
        byte value = buffer[this.bStart];
        this.bStart++;
        this.bSize--;
        if (value == (byte) Connection.END_OF_STREAM) {
            this.wait = true;
            break;
        }
        b[n + off] = value;
    }
    return (n > 0 || !this.wait) ? n : EOS_RESULT;
}