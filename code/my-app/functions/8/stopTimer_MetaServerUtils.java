private static boolean stopTimer(final ServerInfo si) {
    Timer t = findTimer(si);
    if (t == null)
        return false;
    t.cancel();
    updaters.remove(t);
    return true;
}