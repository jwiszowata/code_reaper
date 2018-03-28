public static JMenu localizedMenu(StringTemplate template) {
    return new JMenu(Messages.message(template));
}