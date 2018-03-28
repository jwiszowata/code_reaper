private static void requireMercenaryLeaders() {
    synchronized (mercenaryLock) {
        if (mercenaryLeaders == null) {
            mercenaryLeaders = new ArrayList<>();
            collectNames("nameCache.mercenaries.", mercenaryLeaders);
        }
    }
}