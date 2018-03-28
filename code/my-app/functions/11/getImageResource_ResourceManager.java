private static synchronized ImageResource getImageResource(final String key) {
    ImageResource r = mergedContainer.getImageResource(key);
    if (r == null) {
        logger.warning("getImageResource(" + key + ") failed");
        r = mergedContainer.getImageResource(REPLACEMENT_IMAGE);
        if (r == null) {
            FreeColClient.fatal("Failed getting replacement image.");
        }
    }
    return r;
}