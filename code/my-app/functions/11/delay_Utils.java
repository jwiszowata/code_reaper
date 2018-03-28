public static void delay(long ms, String warning) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException ie) {
        if (warning == null) {
            Thread.currentThread().interrupt();
        } else {
            logger.log(Level.WARNING, warning, ie);
        }
    }
}