public void update(DiplomaticTrade dt) {
    ActionListener[] listeners = this.victimBox.getActionListeners();
    for (ActionListener al : listeners) {
        this.victimBox.removeActionListener(al);
    }
    this.victimBox.removeAllItems();
    for (Player p : available) victimBox.addItem(p);
    boolean enable = !available.isEmpty();
    this.label.setEnabled(enable);
    this.clearButton.setEnabled(!enable);
    this.addButton.setEnabled(enable);
    this.victimBox.setEnabled(enable);
    for (ActionListener al : listeners) {
        this.victimBox.addActionListener(al);
    }
}