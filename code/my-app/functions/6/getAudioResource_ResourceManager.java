private static synchronized AudioResource getAudioResource(final String key) {
    final AudioResource r = mergedContainer.getAudioResource(key);
    if (r == null)
        logger.warning("getAudioResource(" + key + ") failed");
    return r;
}