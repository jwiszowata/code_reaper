public <T extends Enum<T>> T getAttribute(String attributeName, Class<T> returnClass, T defaultValue) {
    final String attrib = getParent().getAttributeValue(null, attributeName);
    T result = defaultValue;
    if (attrib != null) {
        try {
            result = Enum.valueOf(returnClass, attrib.toUpperCase(Locale.US));
        } catch (Exception e) {
            logger.warning(attributeName + " is not a " + defaultValue.getClass().getName() + ": " + attrib);
        }
    }
    return result;
}