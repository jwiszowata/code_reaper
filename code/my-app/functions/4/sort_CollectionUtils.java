public static <T extends Comparable<? super T>> List<T> sort(Stream<T> stream) {
    final Comparator<T> comparator = Comparator.naturalOrder();
    return (stream == null) ? Collections.<T>emptyList() : sort_internal(stream, comparator);
}