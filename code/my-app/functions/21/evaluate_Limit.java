public boolean evaluate(Game game) {
    Integer lhs = null;
    switch(leftHandSide.getScopeLevel()) {
        case GAME:
            lhs = leftHandSide.getValue(game);
            break;
        default:
            lhs = leftHandSide.getValue();
            break;
    }
    Integer rhs = null;
    switch(rightHandSide.getScopeLevel()) {
        case GAME:
            rhs = rightHandSide.getValue(game);
            break;
        default:
            rhs = rightHandSide.getValue();
            break;
    }
    return evaluate(lhs, rhs);
}