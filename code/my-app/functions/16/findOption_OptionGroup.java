public static FreeColXMLReader findOption(File file, String optionId) {
    if (file.canRead() && optionId != null) {
        try {
            FreeColXMLReader xr = new FreeColXMLReader(file);
            try {
                return xr.seek(optionId);
            } catch (Exception ex) {
                logger.log(Level.WARNING, "Failure finding option: " + optionId, ex);
            }
            xr.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "IO error with " + file, ioe);
        }
    }
    return null;
}