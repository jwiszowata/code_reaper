public static void trace(Logger logger, String warn) {
    LogBuilder lb = new LogBuilder(512);
    lb.add(warn, "\n");
    addStackTrace(lb);
    logger.warning(lb.toString());
}