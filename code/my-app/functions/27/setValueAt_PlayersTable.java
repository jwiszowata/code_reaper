public void setValueAt(Object value, int row, int column) {
    if (row >= 0 && row < getRowCount() && column > 0 && column < getColumnCount()) {
        Nation nation = nations.get(row);
        switch(column) {
            case ADVANTAGE_COLUMN:
                preGameController.setNationType((NationType) value);
                break;
            case AVAILABILITY_COLUMN:
                preGameController.setAvailable(nations.get(row), (NationState) value);
                update();
                break;
            case COLOR_COLUMN:
                preGameController.setColor(nation, (Color) value);
                break;
            case PLAYER_COLUMN:
                if (nationOptions.getNationState(nation) == NationState.AVAILABLE) {
                    preGameController.setNation(nation);
                    preGameController.setNationType(nation.getType());
                    update();
                }
                break;
            default:
                break;
        }
        fireTableCellUpdated(row, column);
    }
}