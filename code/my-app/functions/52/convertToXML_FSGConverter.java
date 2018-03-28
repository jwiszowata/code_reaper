public void convertToXML(InputStream in, OutputStream out) throws IOException {
    try {
        in = new BufferedInputStream(in);
        out = new BufferedOutputStream(out);
        in.mark(10);
        byte[] buf = new byte[5];
        in.read(buf, 0, 5);
        in.reset();
        if (!"<?xml".equals(new String(buf, "UTF-8"))) {
            in = new BufferedInputStream(new GZIPInputStream(in));
        }
        int indent = 0;
        int i;
        while ((i = in.read()) != -1) {
            char c = (char) i;
            if (c == '<') {
                i = in.read();
                char b = (char) i;
                if (b == '/') {
                    indent -= 4;
                }
                for (int h = 0; h < indent; h++) {
                    out.write(' ');
                }
                out.write(c);
                if (b != '\n' && b != '\r') {
                    out.write(b);
                }
                if (b != '/' && b != '?') {
                    indent += 4;
                }
            } else if (c == '/') {
                out.write(c);
                i = in.read();
                c = (char) i;
                if (c == '>') {
                    indent -= 4;
                    out.write(c);
                    out.write('\n');
                }
            } else if (c == '>') {
                out.write(c);
                out.write('\n');
            } else if (c != '\n' && c != '\r') {
                out.write(c);
            }
        }
    } finally {
        in.close();
        out.close();
    }
}