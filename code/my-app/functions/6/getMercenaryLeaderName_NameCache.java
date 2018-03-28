public static String getMercenaryLeaderName(int index) {
    requireMercenaryLeaders();
    synchronized (mercenaryLock) {
        return mercenaryLeaders.get(index);
    }
}