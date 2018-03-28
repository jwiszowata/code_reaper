public BooleanOption clone() {
    BooleanOption result = new BooleanOption(getId(), getSpecification());
    result.setValues(this);
    return result;
}