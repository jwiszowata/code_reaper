public void setString(String id, String value) {
    try {
        ((StringOption) getOption(id)).setValue(value);
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No String" + " value associated with the specified option: " + id, e);
    }
}