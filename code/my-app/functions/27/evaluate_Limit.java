public boolean evaluate(Player player) {
    Integer lhs = null;
    switch(leftHandSide.getScopeLevel()) {
        case PLAYER:
            lhs = leftHandSide.getValue(player);
            break;
        case GAME:
            lhs = leftHandSide.getValue(player.getGame());
            break;
        default:
            lhs = leftHandSide.getValue();
            break;
    }
    Integer rhs = null;
    switch(rightHandSide.getScopeLevel()) {
        case PLAYER:
            rhs = rightHandSide.getValue(player);
            break;
        case GAME:
            rhs = rightHandSide.getValue(player.getGame());
            break;
        default:
            rhs = rightHandSide.getValue();
            break;
    }
    return evaluate(lhs, rhs);
}