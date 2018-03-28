public static long getTimeout(boolean singlePlayer) {
    if (timeout < 0L) {
        timeout = (singlePlayer) ? TIMEOUT_MAX : TIMEOUT_DEFAULT;
    }
    return timeout;
}