public LanguageOption clone() {
    LanguageOption result = new LanguageOption(getSpecification());
    result.setValues(this);
    return result;
}