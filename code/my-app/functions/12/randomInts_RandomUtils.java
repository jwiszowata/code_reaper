public static int[] randomInts(Logger logger, String logMe, Random random, int range, int n) {
    int[] ret = new int[n];
    for (int i = 0; i < n; i++) ret[i] = random.nextInt(range);
    if (logger != null && logger.isLoggable(Level.FINEST)) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(logMe).append(" random(").append(range).append(") = [");
        for (int i = 0; i < n; i++) sb.append(' ').append(ret[i]);
        sb.append(" ]");
        logger.finest(sb.toString());
    }
    return ret;
}