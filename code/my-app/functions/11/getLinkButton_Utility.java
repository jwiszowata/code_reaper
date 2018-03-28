public static JButton getLinkButton(String text, Icon icon, String action) {
    JButton button = new JButton(text, icon);
    button.setMargin(EMPTY_MARGIN);
    button.setOpaque(false);
    button.setForeground(LINK_COLOR);
    button.setAlignmentY(0.8f);
    button.setBorder(blankBorder(0, 0, 0, 0));
    button.setActionCommand(action);
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    return button;
}