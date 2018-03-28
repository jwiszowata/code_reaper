public static double randomDouble(Logger logger, String logMe, Random random) {
    double ret = random.nextDouble();
    if (logger != null && logger.isLoggable(Level.FINEST)) {
        logger.finest(logMe + " random(1.0) = " + ret);
    }
    return ret;
}