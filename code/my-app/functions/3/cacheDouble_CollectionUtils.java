public static <T> ToDoubleFunction<T> cacheDouble(Function<T, Double> f) {
    return t -> new CachingFunction<T, Double>(f).apply(t);
}