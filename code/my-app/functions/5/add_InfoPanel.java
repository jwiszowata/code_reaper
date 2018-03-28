private void add(JPanel panel, int internalTop, int internalHeight) {
    panel.setVisible(false);
    panel.setLocation((getWidth() - panel.getWidth()) / 2, internalTop + (internalHeight - panel.getHeight()) / 2);
    add(panel);
}