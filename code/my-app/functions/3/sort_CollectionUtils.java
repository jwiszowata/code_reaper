public static <T> List<T> sort(Stream<T> stream, Comparator<? super T> comparator) {
    return (stream == null) ? Collections.<T>emptyList() : sort_internal(stream, comparator);
}