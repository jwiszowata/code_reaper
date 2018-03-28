public static void completeAll(ChangeSet cs) {
    List<Session> sessions;
    synchronized (sessionLock) {
        sessions = transform(allSessions.values(), s -> !s.isComplete());
        allSessions.clear();
    }
    for (Session ts : sessions) ts.complete(cs);
}