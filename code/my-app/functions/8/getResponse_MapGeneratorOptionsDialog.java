public OptionGroup getResponse() {
    OptionGroup value = super.getResponse();
    if (value != null) {
        if (isEditable())
            saveDefaultOptions();
    }
    return value;
}