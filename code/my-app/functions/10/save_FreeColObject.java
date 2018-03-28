public boolean save(File file, WriteScope scope, boolean pretty) {
    try (FileOutputStream fos = new FileOutputStream(file)) {
        return save(fos, scope, pretty);
    } catch (FileNotFoundException fnfe) {
        logger.log(Level.WARNING, "No file: " + file.getPath(), fnfe);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Error creating FileOutputStream", ioe);
    }
    return false;
}