private static Selector getSelector(String tag) {
    return tagMap.get(tag.toLowerCase(Locale.US));
}