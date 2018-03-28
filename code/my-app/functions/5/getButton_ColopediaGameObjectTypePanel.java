protected JButton getButton(PanelType panelType, String text, ImageIcon icon) {
    JButton button = Utility.getLinkButton(text, icon, "colopediaAction." + panelType.getKey());
    button.addActionListener(colopediaPanel);
    return button;
}