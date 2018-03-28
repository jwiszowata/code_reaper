public void run() {
    try {
        runnable.run();
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Thread " + name + " fail", e);
    }
}