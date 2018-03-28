public Boolean getBooleanAttribute(String key, Boolean defaultValue) {
    if (hasAttribute(key)) {
        try {
            return Boolean.parseBoolean(getStringAttribute(key));
        } catch (NumberFormatException nfe) {
        }
    }
    return defaultValue;
}