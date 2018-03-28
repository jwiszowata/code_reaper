public TextOption clone() {
    TextOption result = new TextOption(getId(), getSpecification());
    result.setValues(this);
    return result;
}