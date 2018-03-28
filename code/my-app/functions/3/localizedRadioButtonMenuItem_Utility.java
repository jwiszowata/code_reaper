public static JRadioButtonMenuItem localizedRadioButtonMenuItem(StringTemplate template, boolean value) {
    return new JRadioButtonMenuItem(Messages.message(template), value);
}