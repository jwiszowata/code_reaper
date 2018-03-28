private void startCleanupTimer() {
    Timer t = new Timer(true);
    t.scheduleAtFixedRate(new TimerTask() {

        @Override
        public void run() {
            try {
                removeDeadServers();
            } catch (Exception ex) {
                logger.log(Level.WARNING, "Could not remove servers.", ex);
            }
        }
    }, REMOVE_DEAD_SERVERS_INTERVAL, REMOVE_DEAD_SERVERS_INTERVAL);
}