public static <T> T maximize(Stream<T> stream, Predicate<? super T> predicate, Comparator<? super T> comparator) {
    return (stream == null) ? null : maximize_internal(stream, predicate, comparator);
}