protected void setValue(String valueString, String defaultValueString) {
    String str = (valueString != null) ? valueString : defaultValueString;
    try {
        setValue(Integer.valueOf(str));
    } catch (NumberFormatException nfe) {
        logger.log(Level.WARNING, "IntegerOption fail: " + str, nfe);
    }
}