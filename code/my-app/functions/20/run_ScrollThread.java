public void run() {
    while (direction != null) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                if (!canvas.scrollMap(direction))
                    direction = null;
            });
        } catch (InvocationTargetException e) {
            logger.log(Level.WARNING, "Scroll thread caught error", e);
            break;
        } catch (InterruptedException e) {
            break;
        }
        try {
            sleep(SCROLL_DELAY);
        } catch (InterruptedException e) {
            break;
        }
    }
}