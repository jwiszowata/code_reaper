public static String getNextCityOfCibola() {
    synchronized (cibolaLock) {
        return (cibolaKeys == null || cibolaKeys.isEmpty()) ? null : Messages.message(cibolaKeys.remove(0));
    }
}