public int getRiverConnection(Direction direction) {
    int index = Direction.longSides.indexOf(direction);
    if (index == -1 || style == null)
        return 0;
    int mag = Character.digit(style.getString().charAt(index), 10);
    return (mag == -1) ? 0 : mag;
}