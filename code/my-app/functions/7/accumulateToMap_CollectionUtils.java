public static <K, V> void accumulateToMap(Map<K, V> map, K key, V value, BinaryOperator<V> accumulator) {
    if (map.containsKey(key)) {
        map.put(key, accumulator.apply(map.get(key), value));
    } else {
        map.put(key, value);
    }
}