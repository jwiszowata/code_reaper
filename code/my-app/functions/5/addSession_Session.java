private static void addSession(String key, Session session) {
    synchronized (sessionLock) {
        allSessions.put(key, session);
    }
}