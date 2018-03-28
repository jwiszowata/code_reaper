public int read(byte[] buf, int n) throws IOException {
    int wr = 0, wrOffset = 0;
    while (n > 0) {
        if (bufCount <= 0) {
            int ret = getBody(inputStream);
            if (ret < 0)
                throw new IOException("Ogg decoding error");
            if (ret == 0)
                break;
            bufCount = ret;
            offset = 0;
        }
        int rd = (bufCount < n) ? bufCount : n;
        System.arraycopy(convBuf, offset, buf, wrOffset, rd);
        bufCount -= rd;
        offset += rd;
        wr += rd;
        wrOffset += rd;
        n -= rd;
    }
    return (wr <= 0) ? -1 : wr;
}