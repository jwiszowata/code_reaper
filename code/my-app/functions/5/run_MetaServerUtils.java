public void run() {
    ServerInfo si = updaters.get(this);
    if (si == null || !updateServer(si))
        cancel();
}