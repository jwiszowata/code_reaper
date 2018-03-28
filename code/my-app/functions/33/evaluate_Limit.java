public boolean evaluate(Settlement settlement) {
    Integer lhs = null;
    switch(leftHandSide.getScopeLevel()) {
        case SETTLEMENT:
            lhs = leftHandSide.getValue(settlement);
            break;
        case PLAYER:
            lhs = leftHandSide.getValue(settlement.getOwner());
            break;
        case GAME:
            lhs = leftHandSide.getValue(settlement.getGame());
            break;
        default:
            lhs = leftHandSide.getValue();
            break;
    }
    Integer rhs = null;
    switch(rightHandSide.getScopeLevel()) {
        case SETTLEMENT:
            rhs = rightHandSide.getValue(settlement);
            break;
        case PLAYER:
            rhs = rightHandSide.getValue(settlement.getOwner());
            break;
        case GAME:
            rhs = rightHandSide.getValue(settlement.getGame());
            break;
        default:
            rhs = rightHandSide.getValue();
            break;
    }
    return evaluate(lhs, rhs);
}