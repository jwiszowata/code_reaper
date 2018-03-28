public String getString(String id) {
    try {
        return ((StringOption) getOption(id)).getValue();
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No String" + " value associated with the specified option: " + id, e);
    }
}