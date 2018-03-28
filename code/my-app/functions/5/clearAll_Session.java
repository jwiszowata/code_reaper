public static void clearAll() {
    synchronized (sessionLock) {
        allSessions.clear();
    }
}