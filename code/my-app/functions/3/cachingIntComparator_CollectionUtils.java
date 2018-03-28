public static <T> Comparator<T> cachingIntComparator(Function<T, Integer> f) {
    return Comparator.comparingInt(cacheInt(f));
}