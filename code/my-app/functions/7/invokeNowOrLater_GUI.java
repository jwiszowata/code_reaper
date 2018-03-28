public void invokeNowOrLater(Runnable runnable) {
    if (SwingUtilities.isEventDispatchThread()) {
        runnable.run();
    } else {
        SwingUtilities.invokeLater(runnable);
    }
}