public static <T> T find(Stream<T> stream, Predicate<? super T> predicate, T fail) {
    return (stream == null) ? fail : find_internal(stream, predicate, fail);
}