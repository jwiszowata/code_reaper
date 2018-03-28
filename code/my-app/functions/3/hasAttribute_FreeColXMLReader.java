public boolean hasAttribute(String attributeName) {
    return getParent().getAttributeValue(null, attributeName) != null;
}