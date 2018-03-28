public java.util.Map<String, String> getStatistics() {
    java.util.Map<String, String> stats = new HashMap<>();
    System.gc();
    long free = Runtime.getRuntime().freeMemory() / (1024 * 1024);
    long total = Runtime.getRuntime().totalMemory() / (1024 * 1024);
    long max = Runtime.getRuntime().maxMemory() / (1024 * 1024);
    stats.put("freeMemory", Long.toString(free));
    stats.put("totalMemory", Long.toString(total));
    stats.put("maxMemory", Long.toString(max));
    java.util.Map<String, Long> objStats = new HashMap<>();
    long disposed = 0;
    for (FreeColGameObject fcgo : getFreeColGameObjectList()) {
        String className = fcgo.getClass().getSimpleName();
        if (objStats.containsKey(className)) {
            Long count = objStats.get(className);
            count++;
            objStats.put(className, count);
        } else {
            Long count = (long) 1;
            objStats.put(className, count);
        }
        if (fcgo.isDisposed())
            disposed++;
    }
    stats.put("disposed", Long.toString(disposed));
    forEachMapEntry(objStats, e -> stats.put(e.getKey(), Long.toString(e.getValue())));
    return stats;
}