public Object getValueAt(int rowIndex, int columnIndex) {
    if (0 == columnIndex) {
        return leftLineAtRow(rowIndex);
    } else if (1 == columnIndex) {
        return rightLineAtRow(rowIndex);
    } else {
        throw new RuntimeException(Integer.toString(columnIndex));
    }
}