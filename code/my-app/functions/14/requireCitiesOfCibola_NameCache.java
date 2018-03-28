public static void requireCitiesOfCibola(Random random) {
    synchronized (cibolaLock) {
        if (cibolaKeys == null) {
            cibolaKeys = new ArrayList<>();
            collectNames(CIBOLA_PREFIX, cibolaKeys);
            int count = cibolaKeys.size();
            cibolaKeys.clear();
            for (int i = 0; i < count; i++) {
                cibolaKeys.add(CIBOLA_PREFIX + i);
            }
            randomShuffle(logger, "Cibola", cibolaKeys, random);
        }
    }
}