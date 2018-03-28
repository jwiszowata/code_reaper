public static JLabel localizedHeaderLabel(StringTemplate template, int alignment, FontLibrary.FontSize size) {
    String text = Messages.message(template);
    JLabel header = new JLabel(text, alignment);
    header.setFont(FontLibrary.createCompatibleFont(text, FontLibrary.FontType.HEADER, size));
    header.setOpaque(false);
    return header;
}