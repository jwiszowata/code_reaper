private void update() {
    this.optionPanel.removeAll();
    this.ui = new OptionGroupUI(getGUI(), this.group, this.editable);
    this.optionPanel.add(this.ui);
    invalidate();
    validate();
    repaint();
}