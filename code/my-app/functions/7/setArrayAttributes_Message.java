public void setArrayAttributes(String[] attributes) {
    if (attributes != null) {
        for (int i = 0; i < attributes.length; i++) {
            setStringAttribute(FreeColObject.arrayKey(i), attributes[i]);
        }
    }
}