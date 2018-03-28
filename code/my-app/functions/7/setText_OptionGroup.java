public void setText(String id, String value) {
    try {
        ((TextOption) getOption(id)).setValue(value);
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No String" + " value associated with the specified option: " + id, e);
    }
}