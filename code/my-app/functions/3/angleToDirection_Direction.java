public static Direction angleToDirection(double angle) {
    return Direction.values()[(int) Math.floor(angle / (Math.PI / 4))];
}