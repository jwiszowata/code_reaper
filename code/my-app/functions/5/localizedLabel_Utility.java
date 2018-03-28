public static JLabel localizedLabel(StringTemplate template, Icon icon, int alignment) {
    JLabel label = new JLabel(Messages.message(template), icon, alignment);
    label.setOpaque(false);
    return label;
}