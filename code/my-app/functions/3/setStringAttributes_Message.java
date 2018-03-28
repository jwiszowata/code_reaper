public void setStringAttributes(Map<String, String> attributes) {
    forEachMapEntry(attributes, e -> setStringAttribute(e.getKey(), e.getValue()));
}