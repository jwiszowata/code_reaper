public static <T extends Session> T lookup(Class<T> type, String s1, String s2) {
    String key = makeSessionKey(type, s1, s2);
    Session ts = getSession(key);
    if (ts != null && ts.isComplete()) {
        synchronized (sessionLock) {
            allSessions.remove(key);
        }
        ts = null;
    }
    return (ts == null) ? null : type.cast(ts);
}