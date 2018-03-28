public static boolean directoryAllPresent(File dir, String... names) {
    if (dir == null || !dir.isDirectory() || !dir.canRead())
        return false;
    for (String n : names) {
        if (!new File(dir, n).canRead())
            return false;
    }
    return true;
}