public <T extends StringTemplate> T addStringTemplate(StringTemplate template) {
    if (this.templateType != TemplateType.LABEL) {
        throw new IllegalArgumentException("Cannot add a template" + " to StringTemplate." + this.templateType);
    }
    return complete(null, template);
}