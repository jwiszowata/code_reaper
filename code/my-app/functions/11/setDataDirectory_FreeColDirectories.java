public static String setDataDirectory(String path) {
    if (path == null)
        path = DATA_DIRECTORY;
    File dir = new File(path);
    if (!dir.isDirectory())
        return "Not a directory: " + path;
    if (!dir.canRead())
        return "Can not read directory: " + path;
    dataDirectory = dir;
    return null;
}