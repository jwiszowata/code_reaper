private final <T extends StringTemplate> T complete(String key, StringTemplate value) {
    if (key != null)
        addKey(key);
    addReplacement(value);
    return (T) this;
}