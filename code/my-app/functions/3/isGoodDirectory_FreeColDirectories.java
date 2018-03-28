private static boolean isGoodDirectory(File f) {
    return f.exists() && f.isDirectory() && f.canWrite();
}