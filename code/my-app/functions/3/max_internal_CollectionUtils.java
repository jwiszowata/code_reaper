private static <T> int max_internal(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return stream.filter(predicate).mapToInt(tif).max().orElse(MAX_DEFAULT);
}