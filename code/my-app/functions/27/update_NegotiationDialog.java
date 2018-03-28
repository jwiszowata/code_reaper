private void update(DiplomaticTrade dt) {
    if (!source.isEuropean())
        return;
    ActionListener[] listeners = this.colonyBox.getActionListeners();
    for (ActionListener al : listeners) {
        this.colonyBox.removeActionListener(al);
    }
    List<Colony> available = new ArrayList<>(allColonies);
    for (Colony c : dt.getColoniesGivenBy(source)) {
        if (available.contains(c)) {
            available.remove(c);
        } else {
            allColonies.add(c);
        }
    }
    available.sort(getFreeColClient().getClientOptions().getColonyComparator());
    this.colonyBox.removeAllItems();
    for (Colony c : available) this.colonyBox.addItem(c);
    boolean enable = !available.isEmpty();
    this.clearButton.setEnabled(!enable);
    this.addButton.setEnabled(enable);
    this.colonyBox.setEnabled(enable);
    this.label.setEnabled(enable);
    for (ActionListener al : listeners) {
        this.colonyBox.addActionListener(al);
    }
}