public static <K, V> List<Entry<K, V>> mapEntriesByValue(Map<K, V> map, final Comparator<V> comparator) {
    return sort(map.entrySet(), Comparator.comparing(Entry::getValue, comparator));
}