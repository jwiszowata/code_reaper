public void setBoolean(String id, boolean value) {
    try {
        ((BooleanOption) getOption(id)).setValue(value);
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No boolean" + " value associated with the specified option: " + id, e);
    }
}