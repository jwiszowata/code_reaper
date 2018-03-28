public boolean hasOperandType(OperandType type) {
    return leftHandSide.getOperandType() == type || rightHandSide.getOperandType() == type;
}