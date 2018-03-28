private void update(DiplomaticTrade dt) {
    ActionListener[] listeners = unitBox.getActionListeners();
    for (ActionListener al : listeners) {
        unitBox.removeActionListener(al);
    }
    List<Unit> available = new ArrayList<>(allUnits);
    for (Unit u : dt.getUnitsGivenBy(source)) {
        if (available.contains(u)) {
            available.remove(u);
        } else {
            allUnits.add(u);
        }
    }
    unitBox.removeAllItems();
    for (Unit u : available) unitBox.addItem(u);
    boolean enable = !available.isEmpty();
    this.label.setEnabled(enable);
    clearButton.setEnabled(!enable);
    addButton.setEnabled(enable);
    unitBox.setEnabled(enable);
    for (ActionListener al : listeners) {
        unitBox.addActionListener(al);
    }
}