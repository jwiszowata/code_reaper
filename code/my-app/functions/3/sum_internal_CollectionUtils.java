private static <T> int sum_internal(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return stream.filter(predicate).mapToInt(tif).sum();
}