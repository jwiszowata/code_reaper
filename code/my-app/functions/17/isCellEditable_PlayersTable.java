public boolean isCellEditable(int row, int column) {
    if (row >= 0 && row < getRowCount()) {
        Nation nation = nations.get(row);
        boolean ownRow = thisPlayer == nationMap.get(nation) && !thisPlayer.isReady();
        switch(column) {
            case AVAILABILITY_COLUMN:
                return !ownRow && thisPlayer.isAdmin();
            case ADVANTAGE_COLUMN:
                return nation.getType() instanceof EuropeanNationType && ownRow;
            case COLOR_COLUMN:
                return nation.getType() instanceof EuropeanNationType;
            case PLAYER_COLUMN:
                return nation.getType() instanceof EuropeanNationType && nationMap.get(nation) == null;
        }
    }
    return false;
}