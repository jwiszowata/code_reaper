public static JTextArea localizedTextArea(StringTemplate template, int columns) {
    return getDefaultTextArea(Messages.message(template), columns);
}