private JButton createColonyButton(Colony colony, String info, boolean headline) {
    String text = colony.getName() + info;
    JButton button = Utility.getLinkButton(text, null, colony.getId());
    if (headline) {
        button.setFont(FontLibrary.createCompatibleFont(text, FontLibrary.FontType.HEADER, FontLibrary.FontSize.SMALL));
    }
    button.addActionListener(this);
    return button;
}