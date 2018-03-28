protected void setValue(String valueString, String defaultValueString) {
    if (valueString != null) {
        value = new File(valueString);
    } else if (defaultValueString != null) {
        value = new File(defaultValueString);
    } else {
        value = null;
    }
}