protected void log(Element element, boolean send) {
    if (this.logWriter == null)
        return;
    synchronized (this.logWriter) {
        StringWriter sw = elementToStringWriter(this.logTransformer, element);
        if (sw == null)
            return;
        StringBuffer sb = sw.getBuffer();
        try {
            sb.insert(0, (send) ? SEND_SUFFIX : REPLY_SUFFIX);
            sb.insert(0, name);
            this.logWriter.write(sb.toString());
            this.logWriter.flush();
        } catch (IOException ioe) {
            ;
        }
    }
}