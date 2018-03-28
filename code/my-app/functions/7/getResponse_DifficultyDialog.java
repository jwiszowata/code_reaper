public OptionGroup getResponse() {
    OptionGroup value = super.getResponse();
    if (value != null) {
        FreeCol.setDifficulty(value);
    }
    return value;
}