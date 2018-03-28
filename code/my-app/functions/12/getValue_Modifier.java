public final float getValue(Turn turn) {
    if (appliesTo(turn)) {
        if (hasIncrement()) {
            float f = (turn.getNumber() - getFirstTurn().getNumber()) * increment;
            return apply(value, f, incrementType);
        } else {
            return value;
        }
    } else {
        return 0;
    }
}