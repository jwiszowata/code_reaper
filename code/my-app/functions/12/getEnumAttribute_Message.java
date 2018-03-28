public <T extends Enum<T>> T getEnumAttribute(String key, Class<T> returnClass, T defaultValue) {
    T result = defaultValue;
    if (hasAttribute(key)) {
        String kv = getStringAttribute(key);
        try {
            result = Enum.valueOf(returnClass, kv);
        } catch (Exception e) {
            logger.warning("Not a " + defaultValue.getClass().getName() + ": " + kv);
        }
    }
    return result;
}