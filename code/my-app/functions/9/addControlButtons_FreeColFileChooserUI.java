protected void addControlButtons() {
    JPanel buttonPanel = getButtonPanel();
    Component[] buttons = buttonPanel.getComponents();
    buttonPanel.removeAll();
    for (int i = buttons.length - 1; i >= 0; i--) {
        buttonPanel.add(buttons[i]);
    }
    super.addControlButtons();
}