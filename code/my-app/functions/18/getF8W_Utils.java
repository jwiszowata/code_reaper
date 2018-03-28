private static Writer getF8W(File file, boolean append) {
    FileOutputStream fos;
    try {
        fos = new FileOutputStream(file, append);
    } catch (FileNotFoundException e) {
        logger.log(Level.WARNING, "No FileOutputStream for " + file.getName(), e);
        return null;
    }
    Writer wr = getUTF8Writer(fos);
    if (wr == null) {
        try {
            fos.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to close", ioe);
        }
    }
    return wr;
}