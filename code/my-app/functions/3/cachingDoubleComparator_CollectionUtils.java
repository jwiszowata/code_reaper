public static <T> Comparator<T> cachingDoubleComparator(Function<T, Double> f) {
    return Comparator.comparingDouble(cacheDouble(f));
}