public static <T> boolean all(Stream<T> stream, Predicate<? super T> predicate) {
    return (stream == null) ? true : all_internal(stream, predicate);
}