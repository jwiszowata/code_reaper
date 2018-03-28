public int getCount(T key) {
    Integer value = values.get(key);
    return value == null ? 0 : value;
}