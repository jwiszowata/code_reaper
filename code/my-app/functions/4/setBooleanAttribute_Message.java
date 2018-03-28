public void setBooleanAttribute(String key, Boolean value) {
    if (value != null)
        setStringAttribute(key, Boolean.toString(value));
}