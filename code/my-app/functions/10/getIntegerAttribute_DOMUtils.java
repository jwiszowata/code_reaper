public static int getIntegerAttribute(Element element, String tag, int defaultValue) {
    if (element != null && element.hasAttribute(tag)) {
        String str = element.getAttribute(tag);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
    }
    return defaultValue;
}