private static void initializeLanguages() {
    if (!languages.isEmpty())
        return;
    for (String languageId : FreeColDirectories.getLanguageIdList()) {
        if (languageId == null)
            continue;
        try {
            languages.add(new Language(languageId, Messages.getLocale(languageId)));
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to add: " + languageId, e);
        }
    }
    languages.sort(Comparator.naturalOrder());
    languages.add(0, DEFAULT_LANGUAGE);
}