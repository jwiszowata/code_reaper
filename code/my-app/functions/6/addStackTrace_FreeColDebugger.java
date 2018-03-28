public static void addStackTrace(LogBuilder lb) {
    for (StackTraceElement s : Thread.currentThread().getStackTrace()) {
        lb.add(s.toString(), "\n");
    }
    lb.shrink("\n");
}