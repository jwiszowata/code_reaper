public OptionGroup getResponse() {
    OptionGroup value = super.getResponse();
    if (value == null) {
        ;
    } else {
        getOptionUI().updateOption();
    }
    return value;
}