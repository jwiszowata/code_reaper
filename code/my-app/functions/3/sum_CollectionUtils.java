public static <T> int sum(Stream<T> stream, Predicate<? super T> predicate, ToIntFunction<T> tif) {
    return (stream == null) ? SUM_DEFAULT : sum_internal(stream, predicate, tif);
}