public static List<String> getCitiesOfCibola() {
    synchronized (cibolaLock) {
        return (cibolaKeys == null) ? Collections.<String>emptyList() : cibolaKeys;
    }
}