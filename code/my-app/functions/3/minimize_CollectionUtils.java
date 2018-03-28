public static <T> T minimize(Stream<T> stream, Predicate<? super T> predicate, Comparator<? super T> comparator) {
    return (stream == null) ? null : minimize_internal(stream, predicate, comparator);
}