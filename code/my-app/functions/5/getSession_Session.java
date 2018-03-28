private static Session getSession(String key) {
    synchronized (sessionLock) {
        return allSessions.get(key);
    }
}