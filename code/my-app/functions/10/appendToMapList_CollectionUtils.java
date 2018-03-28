public static <T, K> void appendToMapList(Map<K, List<T>> map, K key, T value) {
    List<T> l = map.get(key);
    if (l == null) {
        l = new ArrayList<>();
        l.add(value);
        map.put(key, l);
    } else if (!l.contains(value)) {
        l.add(value);
    }
}