public static void localizeBorder(JComponent component, StringTemplate template) {
    TitledBorder tb = (TitledBorder) component.getBorder();
    tb.setTitle(Messages.message(template));
}