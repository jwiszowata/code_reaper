public static <K, V> void accumulateMap(Map<K, V> map1, Map<K, V> map2, BinaryOperator<V> accumulator) {
    forEachMapEntry(map2, e -> accumulateToMap(map1, e.getKey(), e.getValue(), accumulator));
}