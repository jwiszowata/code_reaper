public static <T> boolean none(Stream<T> stream, Predicate<? super T> predicate) {
    return (stream == null) ? true : none_internal(stream, predicate);
}