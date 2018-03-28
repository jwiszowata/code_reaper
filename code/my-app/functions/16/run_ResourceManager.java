public void run() {
    logger.info("Preload background thread started");
    List<Resource> resources = new ArrayList<>(getResources().values());
    int n = 0;
    for (Resource r : resources) {
        if (preloadThread != this) {
            logger.info("Preload background thread cancelled" + " after it preloaded " + n + " resources.");
            return;
        }
        if (r instanceof Resource.Preloadable) {
            ((Resource.Preloadable) r).preload();
            n++;
        }
    }
    logger.info("Preload background thread preloaded " + n + " resources.");
}