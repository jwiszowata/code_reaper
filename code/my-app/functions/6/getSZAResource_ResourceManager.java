private static synchronized SZAResource getSZAResource(final String key) {
    final SZAResource r = mergedContainer.getSZAResource(key);
    if (r == null)
        logger.warning("getSZAResource(" + key + ") failed");
    return r;
}