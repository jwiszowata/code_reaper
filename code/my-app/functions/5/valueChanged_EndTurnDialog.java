public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting())
        return;
    selectUnit();
}