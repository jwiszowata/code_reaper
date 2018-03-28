public static <T, K> Predicate<T> matchKeyEquals(final K key, Function<T, K> mapper) {
    return t -> Utils.equals(mapper.apply(t), key);
}