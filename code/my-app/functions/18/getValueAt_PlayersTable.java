public Object getValueAt(int row, int column) {
    if (row >= 0 && row < getRowCount() && column >= 0 && column < getColumnCount()) {
        Nation nation = nations.get(row);
        switch(column) {
            case NATION_COLUMN:
                return nation;
            case AVAILABILITY_COLUMN:
                return nationOptions.getNationState(nation);
            case ADVANTAGE_COLUMN:
                return (nationMap.get(nation) == null) ? nation.getType() : nationMap.get(nation).getNationType();
            case COLOR_COLUMN:
                return nation.getColor();
            case PLAYER_COLUMN:
                return nationMap.get(nation);
        }
    }
    return null;
}