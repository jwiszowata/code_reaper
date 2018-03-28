protected void initialize() {
    JComponent component = getComponent();
    component.setToolTipText(label.getToolTipText());
    component.setEnabled(editable);
    component.setOpaque(false);
}