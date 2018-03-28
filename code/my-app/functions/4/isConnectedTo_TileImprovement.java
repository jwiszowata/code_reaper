public boolean isConnectedTo(Direction direction) {
    int index = isRoad() ? direction.ordinal() : isRiver() ? Direction.longSides.indexOf(direction) : -1;
    return (index == -1 || style == null) ? false : style.getString().charAt(index) != '0';
}