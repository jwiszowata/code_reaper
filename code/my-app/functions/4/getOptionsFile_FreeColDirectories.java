public static File getOptionsFile(String fileName) {
    File dir = getOptionsDirectory();
    return (dir == null) ? null : new File(dir, sanitize(fileName));
}