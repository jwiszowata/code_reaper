public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    Component[] components = getComponents();
    for (Component component : components) {
        component.setEnabled(enabled);
    }
    table.setEnabled(enabled);
}