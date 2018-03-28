public String toString() {
    if (Messages.AUTOMATIC.equals(getKey())) {
        return Messages.message("clientOptions.gui.languageOption.autoDetectLanguage");
    }
    String name = locale.getDisplayName(locale);
    if (name.equals(key) && languageNames.containsKey(key)) {
        name = languageNames.get(key);
    }
    return capitalize(name, locale);
}