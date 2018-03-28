public static <T, R> Stream<R> flatten(Stream<T> stream, Function<? super T, ? extends Stream<? extends R>> mapper) {
    return (stream == null) ? Stream.<R>empty() : flatten_internal(stream, alwaysTrue(), mapper);
}