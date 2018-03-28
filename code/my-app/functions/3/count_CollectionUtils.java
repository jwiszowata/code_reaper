public static <T> int count(Stream<T> stream, Predicate<? super T> predicate) {
    return (stream == null) ? 0 : count_internal(stream, predicate);
}