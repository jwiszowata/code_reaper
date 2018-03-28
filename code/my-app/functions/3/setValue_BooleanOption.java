protected void setValue(String valueString, String defaultValueString) {
    setValue(Boolean.valueOf((valueString != null) ? valueString : defaultValueString));
}