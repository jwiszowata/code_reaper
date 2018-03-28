public OptionGroup getOptionGroup(String id) {
    try {
        return ((OptionGroup) getOption(id)).getValue();
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("No option group" + " value associated with the specified option: " + id, e);
    }
}