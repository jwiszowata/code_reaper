protected boolean load(File file) {
    OptionGroup og = OptionGroup.load(file, getOptionGroupId(), getSpecification());
    if (og == null)
        return false;
    set(og);
    return true;
}