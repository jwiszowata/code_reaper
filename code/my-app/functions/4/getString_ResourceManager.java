public static String getString(final String key) {
    final StringResource r = getStringResource(key);
    return (r == null) ? REPLACEMENT_STRING : r.getString();
}