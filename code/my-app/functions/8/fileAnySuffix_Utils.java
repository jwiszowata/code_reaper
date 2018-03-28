public static boolean fileAnySuffix(File file, String... suffixes) {
    if (file == null || !file.isFile() || !file.canRead())
        return false;
    final String name = file.getName();
    for (String s : suffixes) if (name.endsWith(s))
        return true;
    return false;
}