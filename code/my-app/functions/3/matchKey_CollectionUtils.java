public static <T, K> Predicate<T> matchKey(final K key, Function<T, K> mapper) {
    return t -> mapper.apply(t) == key;
}