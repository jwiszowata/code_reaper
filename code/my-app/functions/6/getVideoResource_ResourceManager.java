private static synchronized VideoResource getVideoResource(final String key) {
    final VideoResource r = mergedContainer.getVideoResource(key);
    if (r == null)
        logger.warning("getVideoResource(" + key + ") failed");
    return r;
}