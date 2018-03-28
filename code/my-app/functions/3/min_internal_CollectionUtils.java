private static <T> int min_internal(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return stream.filter(predicate).mapToInt(tif).min().orElse(MIN_DEFAULT);
}