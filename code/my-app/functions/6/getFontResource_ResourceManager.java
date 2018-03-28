private static synchronized FontResource getFontResource(final String key) {
    final FontResource r = mergedContainer.getFontResource(key);
    if (r == null)
        logger.warning("getFontResource(" + key + ") failed");
    return r;
}