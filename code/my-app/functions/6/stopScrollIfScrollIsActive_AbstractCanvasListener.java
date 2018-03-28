protected void stopScrollIfScrollIsActive() {
    if (scrollThread != null) {
        scrollThread.interrupt();
        scrollThread = null;
    }
}