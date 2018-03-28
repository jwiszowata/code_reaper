public void setInteger(String id, int value) {
    try {
        ((IntegerOption) getOption(id)).setValue(value);
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No integer" + " value associated with the specified option: " + id, e);
    }
}