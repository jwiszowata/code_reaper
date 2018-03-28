private JButton createButton(String name, ActionListener listener) {
    JButton button = new JButton(name);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setOpaque(false);
    button.setHorizontalAlignment(SwingConstants.LEADING);
    button.setForeground(Utility.LINK_COLOR);
    button.setBorder(Utility.LEFTCELLBORDER);
    button.addActionListener(listener);
    return button;
}