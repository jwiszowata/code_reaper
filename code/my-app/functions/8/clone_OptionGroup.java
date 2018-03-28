public OptionGroup clone() {
    OptionGroup result = new OptionGroup(this.getId(), getSpecification());
    result.editable = this.editable;
    result.setValues(this);
    result.options.addAll(this.options);
    result.optionMap.putAll(this.optionMap);
    return result;
}