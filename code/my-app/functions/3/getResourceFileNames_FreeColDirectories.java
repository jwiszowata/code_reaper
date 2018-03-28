public static List<String> getResourceFileNames() {
    return getLocaleFileNames(RESOURCE_FILE_PREFIX, RESOURCE_FILE_SUFFIX, Locale.getDefault());
}