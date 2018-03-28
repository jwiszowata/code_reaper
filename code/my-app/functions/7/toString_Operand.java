public String toString() {
    if (this.value != null)
        return Integer.toString(value);
    StringBuffer sb = new StringBuffer();
    sb.append("[Operand type=").append(this.operandType).append(" scopeLevel=").append(this.scopeLevel);
    return super.toString().replaceFirst("^[^ ]*", sb.toString());
}