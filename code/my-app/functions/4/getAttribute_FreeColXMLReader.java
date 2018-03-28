public String getAttribute(String attributeName, String defaultValue) {
    final String attrib = getParent().getAttributeValue(null, attributeName);
    return (attrib == null) ? defaultValue : attrib;
}