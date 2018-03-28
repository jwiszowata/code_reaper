public List<String> getArrayAttributes() {
    List<String> ret = new ArrayList<>();
    int n = getIntegerAttribute(FreeColObject.ARRAY_SIZE_TAG, -1);
    for (int i = 0; i < n; i++) {
        String key = FreeColObject.arrayKey(i);
        if (!hasAttribute(key))
            break;
        ret.add(getStringAttribute(key));
    }
    return ret;
}