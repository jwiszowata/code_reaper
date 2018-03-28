public Class<?> getColumnClass(int column) {
    switch(column) {
        case NATION_COLUMN:
            return Nation.class;
        case AVAILABILITY_COLUMN:
            return NationOptions.NationState.class;
        case ADVANTAGE_COLUMN:
            return NationType.class;
        case COLOR_COLUMN:
            return Color.class;
        case PLAYER_COLUMN:
            return Player.class;
    }
    return String.class;
}