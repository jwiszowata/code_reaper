public float applyTo(float number, Turn turn) {
    return (incrementType == null) ? apply(number, value) : apply(number, getValue(turn), getType());
}