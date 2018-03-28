public static <T> int min(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return (stream == null) ? MIN_DEFAULT : min_internal(stream, predicate, tif);
}