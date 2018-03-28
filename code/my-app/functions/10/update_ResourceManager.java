private static void update(boolean newItems) {
    logger.finest("update(" + newItems + ")");
    if (newItems) {
        preloadThread = null;
    }
    createMergedContainer();
    if (newItems) {
        startBackgroundPreloading();
    }
}