public int getInteger(String id) {
    try {
        return ((IntegerOption) getOption(id)).getValue();
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No integer" + " value associated with the specified option: " + id, e);
    }
}