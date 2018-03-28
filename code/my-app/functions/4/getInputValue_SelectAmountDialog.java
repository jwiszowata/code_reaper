protected Integer getInputValue() {
    Object value = this.comboBox.getSelectedItem();
    return (value instanceof Integer) ? (Integer) value : -1;
}