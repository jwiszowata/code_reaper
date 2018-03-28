public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting() == false) {
        boolean enabled = (isEditable() && list.getSelectedValue() != null);
        editButton.setEnabled(enabled);
        removeButton.setEnabled(enabled);
        upButton.setEnabled(enabled);
        downButton.setEnabled(enabled);
    }
}