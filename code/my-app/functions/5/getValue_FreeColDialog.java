protected Object getValue() {
    Object value = pane.getValue();
    dispose();
    return value;
}