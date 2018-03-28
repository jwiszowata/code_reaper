protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    if (xr.hasAttribute(OLD_OPERAND_TYPE_TAG)) {
        this.operandType = xr.getAttribute(OLD_OPERAND_TYPE_TAG, OperandType.class, OperandType.NONE);
    } else
        this.operandType = xr.getAttribute(OPERAND_TYPE_TAG, OperandType.class, OperandType.NONE);
    if (xr.hasAttribute(OLD_SCOPE_LEVEL_TAG)) {
        this.scopeLevel = xr.getAttribute(OLD_SCOPE_LEVEL_TAG, ScopeLevel.class, ScopeLevel.NONE);
    } else
        this.scopeLevel = xr.getAttribute(SCOPE_LEVEL_TAG, ScopeLevel.class, ScopeLevel.NONE);
    int val = xr.getAttribute(VALUE_TAG, INFINITY);
    if (val != INFINITY)
        this.value = val;
}