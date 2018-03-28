public static <T> double sumDouble(Stream<T> stream, Predicate<? super T> predicate, ToDoubleFunction<T> tdf) {
    return (stream == null) ? SUM_DOUBLE_DEFAULT : sumDouble_internal(stream, predicate, tdf);
}