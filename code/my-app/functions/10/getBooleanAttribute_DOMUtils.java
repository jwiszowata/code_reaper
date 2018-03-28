public static boolean getBooleanAttribute(Element element, String tag, boolean defaultValue) {
    if (element != null && element.hasAttribute(tag)) {
        String str = element.getAttribute(tag);
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e) {
        }
    }
    return defaultValue;
}