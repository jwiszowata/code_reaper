public static String getLanguageId(File file) {
    if (file == null)
        return null;
    final String name = file.getName();
    if (name == null || !name.startsWith(MESSAGE_FILE_PREFIX) || !name.endsWith(MESSAGE_FILE_SUFFIX))
        return null;
    String languageId = name.substring(MESSAGE_FILE_PREFIX.length(), name.length() - MESSAGE_FILE_SUFFIX.length());
    return // FreeColMessages.properties
    ("".equals(languageId)) ? "en" : // qqq is explanations only
    ("_qqq".equals(languageId)) ? null : (languageId.startsWith("_")) ? languageId.substring(1) : languageId;
}