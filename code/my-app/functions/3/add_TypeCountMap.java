public void add(TypeCountMap<T> other) {
    forEachMapEntry(other.values, e -> incrementCount(e.getKey(), e.getValue()));
}