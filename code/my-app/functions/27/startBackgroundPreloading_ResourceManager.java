private static void startBackgroundPreloading() {
    if ("true".equals(System.getProperty("java.awt.headless", "false"))) {
        return;
    }
    preloadThread = new Thread(FreeCol.CLIENT_THREAD + "-Resource loader") {

        @Override
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
    };
    preloadThread.setPriority(2);
    preloadThread.start();
}