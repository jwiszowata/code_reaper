public IntegerOption clone() {
    IntegerOption result = new IntegerOption(getId(), getSpecification());
    result.setValues(this);
    result.minimumValue = minimumValue;
    result.maximumValue = maximumValue;
    return result;
}