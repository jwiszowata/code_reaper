public boolean getBoolean(String id) {
    try {
        return ((BooleanOption) getOption(id)).getValue();
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No boolean" + " value associated with the specified option: " + id, e);
    }
}