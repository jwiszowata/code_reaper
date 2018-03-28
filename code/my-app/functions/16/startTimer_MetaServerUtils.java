private static boolean startTimer(final ServerInfo si) {
    Timer t = new Timer(true);
    if (t == null)
        return false;
    updaters.put(t, si);
    t.scheduleAtFixedRate(new TimerTask() {

        @Override
        public void run() {
            ServerInfo si = updaters.get(this);
            if (si == null || !updateServer(si))
                cancel();
        }
    }, UPDATE_INTERVAL, UPDATE_INTERVAL);
    return true;
}