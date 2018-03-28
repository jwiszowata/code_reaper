public boolean hasOptionGroup() {
    return any(options, o -> o instanceof OptionGroup);
}