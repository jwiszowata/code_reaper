public <T extends StringTemplate> T add(String value) {
    if (this.templateType != TemplateType.LABEL) {
        throw new IllegalArgumentException("Cannot add a single string" + " to StringTemplate." + this.templateType);
    }
    return complete(null, this.key(value));
}