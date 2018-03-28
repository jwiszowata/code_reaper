public static String getUTF8Contents(File file) {
    String ret = null;
    Reader reader = getFileUTF8Reader(file);
    if (reader != null) {
        CharBuffer cb = CharBuffer.allocate((int) file.length());
        try {
            reader.read(cb);
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Read failed for " + file.getPath(), ioe);
        }
        cb.flip();
        ret = cb.toString();
        try {
            reader.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to close", ioe);
        }
    }
    return ret;
}