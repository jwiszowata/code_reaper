private static synchronized StringResource getStringResource(final String key) {
    final StringResource r = mergedContainer.getStringResource(key);
    if (r == null)
        logger.warning("getStringResource(" + key + ") failed");
    return r;
}