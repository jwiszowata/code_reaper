public static String stackTraceToString() {
    LogBuilder lb = new LogBuilder(512);
    addStackTrace(lb);
    return lb.toString();
}