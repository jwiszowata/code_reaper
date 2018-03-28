public static <K, V> void forEachMapEntry(Map<K, V> map, Consumer<Entry<K, V>> consumer) {
    if (map != null && !map.isEmpty() && consumer != null) {
        forEach_internal(map.entrySet().stream(), alwaysTrue(), consumer);
    }
}