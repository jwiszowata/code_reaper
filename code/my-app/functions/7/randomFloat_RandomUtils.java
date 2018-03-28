public static float randomFloat(Logger logger, String logMe, Random random) {
    float ret = random.nextFloat();
    if (logger != null && logger.isLoggable(Level.FINEST)) {
        logger.finest(logMe + " random(1.0f) = " + ret);
    }
    return ret;
}