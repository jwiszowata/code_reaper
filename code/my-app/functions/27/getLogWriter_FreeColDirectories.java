public static Writer getLogWriter() throws FreeColException {
    String path = getLogFilePath();
    File file = new File(path);
    if (file.exists()) {
        if (file.isDirectory()) {
            throw new FreeColException("Log file \"" + path + "\" could not be created.");
        } else if (file.isFile()) {
            try {
                file.delete();
            } catch (SecurityException ex) {
            }
        }
    }
    try {
        file.createNewFile();
    } catch (IOException e) {
        throw new FreeColException("Log file \"" + path + "\" could not be created.", e);
    }
    if (!file.canWrite()) {
        throw new FreeColException("Can not write in log file \"" + path + "\".");
    }
    Writer writer = Utils.getFileUTF8Writer(file);
    if (writer == null) {
        throw new FreeColException("Can not create writer for log file \"" + path + "\".");
    }
    return writer;
}