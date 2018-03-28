public static <K, V> Map<K, V> makeUnmodifiableMap(K[] keys, V[] values) {
    if (keys.length != values.length) {
        throw new RuntimeException("Length mismatch");
    }
    Map<K, V> tmp = new HashMap<K, V>();
    for (int i = 0; i < keys.length; i++) {
        tmp.put(keys[i], values[i]);
    }
    return Collections.<K, V>unmodifiableMap(tmp);
}