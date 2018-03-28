public Integer incrementCount(T key, int newCount) {
    Integer oldValue = values.get(key);
    if (oldValue == null) {
        return values.put(key, newCount);
    } else if (oldValue == -newCount) {
        values.remove(key);
        return null;
    } else {
        return values.put(key, oldValue + newCount);
    }
}