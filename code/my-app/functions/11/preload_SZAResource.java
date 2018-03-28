public void preload() {
    synchronized (loadingLock) {
        if (szAnimation == null) {
            try {
                szAnimation = new SimpleZippedAnimation(getResourceLocator().toURL());
            } catch (IOException e) {
                logger.log(Level.WARNING, "Could not load SimpleZippedAnimation: " + getResourceLocator(), e);
            }
        }
    }
}