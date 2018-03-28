public static int getMercenaryLeaderIndex(Random random) {
    requireMercenaryLeaders();
    int n;
    synchronized (mercenaryLock) {
        n = mercenaryLeaders.size();
    }
    return randomInt(logger, "Mercenary leader", random, n);
}