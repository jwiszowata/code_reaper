private boolean sendInternal(Element element) throws IOException {
    try {
        synchronized (this.outputLock) {
            if (this.out == null)
                return false;
            StringWriter sw = elementToStringWriter(this.outTransformer, element);
            if (sw == null)
                return false;
            String buf = sw.toString();
            this.out.write(buf.getBytes("UTF-8"));
            this.out.flush();
        }
    } catch (IOException ioe) {
        throw ioe;
    } catch (Exception ex) {
        throw new IOException("sendInternal internal fail", ex);
    }
    return true;
}