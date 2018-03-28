public static String getStringAttribute(Element element, String tag) {
    return (element != null && element.hasAttribute(tag)) ? element.getAttribute(tag) : (String) null;
}