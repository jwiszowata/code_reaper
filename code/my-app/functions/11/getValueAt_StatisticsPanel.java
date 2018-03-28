public Object getValueAt(int row, int column) {
    if ((row < getRowCount()) && (column < getColumnCount()) && (row >= 0) && (column >= 0)) {
        switch(column) {
            case StatisticsModel.NAME_COLUMN:
                return data[NAME_COLUMN][row];
            case StatisticsModel.VALUE_COLUMN:
                return data[VALUE_COLUMN][row];
        }
    }
    return null;
}