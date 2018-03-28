public static <T> ToIntFunction<T> cacheInt(Function<T, Integer> f) {
    return t -> new CachingFunction<T, Integer>(f).apply(t);
}