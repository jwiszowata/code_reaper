public static void clearCitiesOfCibola() {
    synchronized (cibolaLock) {
        if (cibolaKeys != null)
            cibolaKeys.clear();
    }
}