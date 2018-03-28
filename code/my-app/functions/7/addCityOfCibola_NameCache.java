public static void addCityOfCibola(String key) {
    synchronized (cibolaLock) {
        if (cibolaKeys == null)
            cibolaKeys = new ArrayList<>();
        cibolaKeys.add(key);
    }
}