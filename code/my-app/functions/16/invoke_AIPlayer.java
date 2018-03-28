public void invoke(final Runnable runnable) {
    final String name = FreeCol.SERVER_THREAD + "AIPlayer(" + getPlayer().getName() + ")";
    Thread thread = new Thread(name) {

        @Override
        public void run() {
            try {
                runnable.run();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Thread " + name + " fail", e);
            }
        }
    };
    logger.finest("Starting " + name + " " + thread.toString());
    thread.start();
}