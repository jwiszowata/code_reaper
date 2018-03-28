private static synchronized ColorResource getColorResource(final String key) {
    final ColorResource r = mergedContainer.getColorResource(key);
    if (r == null)
        logger.warning("getColorResource(" + key + ") failed");
    return r;
}