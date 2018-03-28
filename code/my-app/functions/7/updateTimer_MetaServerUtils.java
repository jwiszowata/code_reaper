private static boolean updateTimer(final ServerInfo si) {
    Timer t = findTimer(si);
    if (t == null)
        return false;
    updaters.put(t, si);
    return true;
}