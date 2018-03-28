public FoundingFather getResponse() {
    Object value = getValue();
    if (options.get(0).equals(value)) {
        return possibleFathers.get(tb.getSelectedIndex());
    }
    return null;
}