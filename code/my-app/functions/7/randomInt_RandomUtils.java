public static int randomInt(Logger logger, String logMe, Random random, int range) {
    int ret = random.nextInt(range);
    if (logger != null) {
        logger.finest(logMe + " random(" + range + ") = " + ret);
    }
    return ret;
}