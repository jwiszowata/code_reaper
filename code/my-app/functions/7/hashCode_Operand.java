public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + this.operandType.ordinal();
    hash = 31 * hash + this.scopeLevel.ordinal();
    hash = 31 * hash + this.value;
    return hash;
}