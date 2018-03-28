public static <T, V> Predicate<T> isNull(Function<? super T, V> mapper) {
    return (T t) -> mapper.apply(t) == null;
}