private static <T, R> Stream<R> map_internal(Stream<T> stream, Function<? super T, ? extends R> mapper) {
    return stream.map(mapper);
}