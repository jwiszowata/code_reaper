protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(OPERAND_TYPE_TAG, this.operandType);
    xw.writeAttribute(SCOPE_LEVEL_TAG, this.scopeLevel);
    if (this.value != null) {
        xw.writeAttribute(VALUE_TAG, this.value);
    }
}