public static String getKey(String preferredKey, String defaultKey) {
    if (containsKey(preferredKey)) {
        return preferredKey;
    } else {
        return defaultKey;
    }
}