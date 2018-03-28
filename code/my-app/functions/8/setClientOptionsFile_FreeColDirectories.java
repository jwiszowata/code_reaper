public static boolean setClientOptionsFile(String path) {
    File file = new File(path);
    if (file.exists() && file.isFile() && file.canRead()) {
        clientOptionsFile = file;
        return true;
    }
    return false;
}