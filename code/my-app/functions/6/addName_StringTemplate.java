public <T extends StringTemplate> T addName(String value) {
    if (this.templateType != TemplateType.LABEL) {
        throw new IllegalArgumentException("Cannot add a single string" + " to StringTemplate." + this.templateType);
    }
    return complete(null, this.name(value));
}