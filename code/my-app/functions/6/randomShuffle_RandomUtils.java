public static void randomShuffle(Logger logger, String logMe, List<?> list, Random random) {
    if (logger != null && logger.isLoggable(Level.FINEST)) {
        logger.finest(logMe + " shuffle.");
    }
    Collections.shuffle(list, random);
}