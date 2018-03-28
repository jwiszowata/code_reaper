public static Session findSession(Predicate<Session> pred) {
    synchronized (sessionLock) {
        return find(allSessions.values(), pred);
    }
}