public OptionGroup getResponse() {
    OptionGroup value = super.getResponse();
    if (value == null) {
        ;
    } else if (value == resetCookie) {
        load(FreeColDirectories.getBaseClientOptionsFile());
        getOptionUI().updateOption();
        saveDefaultOptions();
        value = getGroup();
    } else {
        saveDefaultOptions();
    }
    return value;
}