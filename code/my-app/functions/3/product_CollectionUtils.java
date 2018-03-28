public static <T> double product(Stream<T> stream, Predicate<? super T> predicate, ToDoubleFunction<T> tdf) {
    return (stream == null) ? PRODUCT_DEFAULT : product_internal(stream, predicate, tdf);
}