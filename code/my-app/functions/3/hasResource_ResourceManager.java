public static synchronized boolean hasResource(final String key) {
    return mergedContainer.containsKey(key);
}