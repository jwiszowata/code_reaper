public static void deleteFiles(List<File> files) {
    for (File f : files) {
        try {
            if (!f.delete()) {
                logger.warning("Failed to delete: " + f.getPath());
            }
        } catch (SecurityException ex) {
            logger.log(Level.WARNING, "Exception deleting: " + f.getPath(), ex);
        }
    }
}