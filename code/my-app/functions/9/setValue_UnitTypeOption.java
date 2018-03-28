protected void setValue(String valueString, String defaultValueString) {
    if (valueString != null) {
        setValue(getSpecification().getUnitType(valueString));
    } else if (defaultValueString != null) {
        setValue(getSpecification().getUnitType(defaultValueString));
    } else {
        setValue(null);
    }
}