private static void copyIfFound(File oldDir, String name, File newDir) {
    File src = new File(oldDir, name);
    File dst = new File(newDir, name);
    if (src.exists() && src.isDirectory() && !dst.exists()) {
        try {
            Files.copy(src.toPath(), dst.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException ioe) {
            System.err.println("Could not copy " + src.toString() + " to " + dst.toString() + ": " + ioe.getMessage());
        }
    }
}