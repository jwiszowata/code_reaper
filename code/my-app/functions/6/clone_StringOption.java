public StringOption clone() {
    StringOption result = new StringOption(getId(), getSpecification());
    result.setValues(this);
    result.setChoices(this.choices);
    return result;
}