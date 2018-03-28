public static Reader getFileUTF8Reader(File file) {
    FileInputStream fis;
    try {
        fis = new FileInputStream(file);
    } catch (FileNotFoundException fnfe) {
        logger.log(Level.WARNING, "No FileInputStream for " + file.getPath(), fnfe);
        return null;
    }
    InputStreamReader isr;
    try {
        isr = new InputStreamReader(fis, "UTF-8");
    } catch (UnsupportedEncodingException uee) {
        logger.log(Level.WARNING, "No InputStreamWriter for " + file.getPath(), uee);
        try {
            fis.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to close", ioe);
        }
        return null;
    }
    return isr;
}