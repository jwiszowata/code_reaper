public void setStringAttributes(String[] attributes) {
    for (int i = 0; i < attributes.length; i += 2) {
        if (attributes[i + 1] != null) {
            setStringAttribute(attributes[i], attributes[i + 1]);
        }
    }
}