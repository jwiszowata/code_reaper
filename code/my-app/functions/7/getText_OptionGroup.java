public String getText(String id) {
    try {
        return ((TextOption) getOption(id)).getValue();
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No String" + " value associated with the specified option: " + id, e);
    }
}