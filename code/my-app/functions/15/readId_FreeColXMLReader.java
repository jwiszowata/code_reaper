public String readId() {
    String id = getAttribute(FreeColObject.ID_ATTRIBUTE_TAG, (String) null);
    if (id == null)
        return null;
    int idx = id.indexOf(":");
    if (idx > 10) {
        String prefix = id.substring(0, idx);
        if ("tileitemcontainer".equals(prefix)) {
            id = "tileItemContainer" + id.substring(idx);
        } else if ("tileimprovement".equals(prefix)) {
            id = "tileImprovement" + id.substring(idx);
        }
    }
    return id;
}