public static <T extends FreeColObject> void logFreeColObjects(Collection<T> c, LogBuilder lb) {
    lb.add("[");
    for (T t : c) lb.add(t.getSuffix(), " ");
    lb.shrink(" ");
    lb.add("]");
}