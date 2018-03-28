private void sleep(int t) {
    try {
        Thread.sleep(t);
    } catch (InterruptedException e) {
        logger.log(Level.WARNING, "Thread used for playing a sound has been interupted.", e);
    }
}