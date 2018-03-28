public static long getFreeColSeed(boolean generate) {
    if (generate) {
        freeColSeed = new SecureRandom().nextLong();
        logger.info("Using seed: " + freeColSeed);
    }
    return freeColSeed;
}