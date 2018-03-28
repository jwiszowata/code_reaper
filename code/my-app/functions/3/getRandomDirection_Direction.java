public static Direction getRandomDirection(String logMe, Logger logger, Random random) {
    return values()[randomInt(logger, logMe, random, NUMBER_OF_DIRECTIONS)];
}