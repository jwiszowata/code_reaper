public static <T, V> Predicate<T> isNotNull(Function<? super T, V> mapper) {
    return (T t) -> mapper.apply(t) != null;
}