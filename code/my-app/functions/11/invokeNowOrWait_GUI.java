public void invokeNowOrWait(Runnable runnable) {
    if (SwingUtilities.isEventDispatchThread()) {
        runnable.run();
    } else {
        try {
            SwingUtilities.invokeAndWait(runnable);
        } catch (InterruptedException | InvocationTargetException ex) {
            logger.log(Level.WARNING, "Client GUI interaction", ex);
        }
    }
}