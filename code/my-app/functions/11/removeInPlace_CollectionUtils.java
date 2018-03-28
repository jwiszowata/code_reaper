public static <K, V> boolean removeInPlace(Map<K, V> map, Predicate<Entry<K, V>> predicate) {
    boolean ret = false;
    Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
        if (predicate.test(iterator.next())) {
            iterator.remove();
            ret = true;
        }
    }
    return ret;
}