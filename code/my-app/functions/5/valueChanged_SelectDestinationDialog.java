public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting())
        return;
    recenter(this.destinationList.getSelectedValue());
}