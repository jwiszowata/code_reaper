private static synchronized FAFileResource getFAFileResource(final String key) {
    final FAFileResource r = mergedContainer.getFAFileResource(key);
    if (r == null)
        logger.warning("getFAFileResource(" + key + ") failed");
    return r;
}