public static Writer getUTF8Writer(OutputStream os) {
    try {
        return new OutputStreamWriter(os, "UTF-8");
    } catch (UnsupportedEncodingException uee) {
        logger.log(Level.WARNING, "No OutputStreamWriter", uee);
    }
    return null;
}