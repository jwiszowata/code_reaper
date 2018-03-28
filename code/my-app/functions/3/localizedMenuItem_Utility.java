public static JMenuItem localizedMenuItem(StringTemplate template, Icon icon) {
    return new JMenuItem(Messages.message(template), icon);
}