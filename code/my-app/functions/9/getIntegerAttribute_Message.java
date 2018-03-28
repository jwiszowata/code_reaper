public Integer getIntegerAttribute(String key, int defaultValue) {
    if (hasAttribute(key)) {
        try {
            return Integer.parseInt(getStringAttribute(key));
        } catch (NumberFormatException nfe) {
        }
    }
    return defaultValue;
}