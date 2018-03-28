public static String getRumourNothingKey(Random random) {
    requireRumourNothingKeys();
    synchronized (rumourNothingLock) {
        return getRandomMember(logger, "nothingKey", rumourNothingKeys, random);
    }
}