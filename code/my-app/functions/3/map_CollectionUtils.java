public static <T, R> Stream<R> map(Stream<T> stream, Function<? super T, ? extends R> mapper) {
    return (stream == null) ? Stream.<R>empty() : map_internal(stream, mapper);
}