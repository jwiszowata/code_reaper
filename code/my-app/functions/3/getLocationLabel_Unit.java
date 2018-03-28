public StringTemplate getLocationLabel() {
    return StringTemplate.template("model.unit.onBoard").addStringTemplate("%unit%", this.getLabel());
}