public static File getAutosaveFile(String fileName) {
    return new File(getAutosaveDirectory(), sanitize(fileName));
}