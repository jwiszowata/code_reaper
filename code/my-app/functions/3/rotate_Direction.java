private Direction rotate(int n) {
    return values()[(ordinal() + n + NUMBER_OF_DIRECTIONS) % NUMBER_OF_DIRECTIONS];
}