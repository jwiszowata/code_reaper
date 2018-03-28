private static void collectKeys(String prefix, List<String> keys, String suffix) {
    String key;
    for (int i = 0; Messages.containsKey(key = prefix + Integer.toString(i) + suffix); i++) keys.add(key);
}