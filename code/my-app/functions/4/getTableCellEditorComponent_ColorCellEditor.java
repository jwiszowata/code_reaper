public Component getTableCellEditorComponent(JTable table, Object value, boolean hasFocus, int row, int column) {
    this.currentColor = (Color) value;
    return this.colorEditButton;
}