public static <T> double product_internal(Stream<T> stream, Predicate<? super T> predicate, ToDoubleFunction<T> tdf) {
    final DoubleBinaryOperator mult = (d1, d2) -> d1 * d2;
    return stream.filter(predicate).mapToDouble(tdf).reduce(PRODUCT_DEFAULT, mult);
}