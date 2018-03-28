public static <K> int incrementMapCount(Map<K, Integer> map, K key) {
    int count = map.containsKey(key) ? map.get(key) : 0;
    map.put(key, count + 1);
    return count + 1;
}