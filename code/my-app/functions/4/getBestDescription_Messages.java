public static String getBestDescription(String id) {
    String key = find(map(DESCRIPTION_KEYS, s -> id + s), k -> containsKey(k));
    return (key == null) ? id : message(key);
}