public static <T> int max(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return (stream == null) ? MAX_DEFAULT : max_internal(stream, predicate, tif);
}