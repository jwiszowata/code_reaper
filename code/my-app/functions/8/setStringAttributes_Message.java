public void setStringAttributes(List<String> attributes) {
    for (int i = 0; i < attributes.size() - 1; i += 2) {
        String k = attributes.get(i);
        String v = attributes.get(i + 1);
        if (k != null && v != null)
            setStringAttribute(k, v);
    }
}