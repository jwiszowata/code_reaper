public long skip(long n) throws IOException {
    long wr = 0;
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
        long rd = (bufCount < n) ? bufCount : n;
        bufCount -= rd;
        offset += rd;
        wr += rd;
        n -= rd;
    }
    return wr;
}