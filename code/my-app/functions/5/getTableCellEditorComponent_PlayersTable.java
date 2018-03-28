public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    NationType nationType = ((Nation) getValueAt(row, NATION_COLUMN)).getType();
    activeBox = (nationType instanceof EuropeanNationType) ? allStateBox : aiStateBox;
    return activeBox;
}