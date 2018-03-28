public void setArrayAttributes(List<String> attributes) {
    if (attributes != null) {
        int i = 0;
        for (String a : attributes) {
            String key = FreeColObject.arrayKey(i);
            i++;
            setStringAttribute(key, a);
        }
        setIntegerAttribute(FreeColObject.ARRAY_SIZE_TAG, i);
    }
}