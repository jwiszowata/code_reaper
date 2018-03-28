public static void incrementFreeColSeed() {
    freeColSeed = getFreeColSeed(false) + 1;
    logger.info("Reseeded with: " + freeColSeed);
}