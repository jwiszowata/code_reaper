protected void setValue(String valueString, String defaultValueString) {
    Language l = null;
    if (l == null && valueString != null) {
        l = getLanguage(valueString);
    }
    if (l == null && defaultValueString != null) {
        l = getLanguage(defaultValueString);
    }
    if (l == null) {
        l = getLanguage(Messages.AUTOMATIC);
    }
    setValue(l);
}