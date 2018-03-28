public static <K, V> List<Entry<K, V>> mapEntriesByKey(Map<K, V> map, final Comparator<K> comparator) {
    return sort(map.entrySet(), Comparator.comparing(Entry::getKey, comparator));
}