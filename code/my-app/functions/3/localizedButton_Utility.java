public static JButton localizedButton(StringTemplate template) {
    return new JButton(Messages.message(template));
}